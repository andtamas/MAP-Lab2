package com.example.Library.controller;

import com.example.Library.model.Member;
import com.example.Library.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // LIST
    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.getAll());
        return "member/index";
    }

    // FORM CREATE
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        return "member/form";
    }

    // CREATE – ID generat automat, folosește Serviciul corectat
    @PostMapping
    public String createMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "member/form"; // Returnează formularul dacă există erori de tip/validare
        }

        try {
            // Logica de creare necesită libraryId, name și email
            memberService.create(member.getName(), member.getEmail(), member.getLibraryId());
        } catch (RuntimeException e) {
            // Capturăm eroarea din Service (ex: "Library with ID 8 not found")
            bindingResult.rejectValue("libraryId", "error.member", e.getMessage());
            return "member/form";
        }

        return "redirect:/members";
    }

    // DETAIL - Unwraps Member
    @GetMapping("/{id}/detail")
    public String viewMember(@PathVariable Long id, Model model) {
        // getById aruncă RuntimeException dacă nu este găsit, tratare OK.
        model.addAttribute("member", memberService.getById(id));
        return "member/detail";
    }

    // FORM EDIT - Unwraps Member
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        // getById aruncă RuntimeException dacă nu este găsit.
        model.addAttribute("member", memberService.getById(id));
        return "member/form";
    }

    // UPDATE – folosește Serviciul corectat
    @PostMapping("/{id}/update")
    public String updateMember(
            @PathVariable Long id,
            @Valid @ModelAttribute("member") Member member,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "member/form";
        }

        try {
            memberService.update(id, member.getName(), member.getEmail());
        } catch (RuntimeException e) {
            // Dacă membrul nu este găsit (ID 12 inexistent), redirecționați
            // la lista principală sau la o pagină de eroare cu un mesaj.
            System.err.println("Eroare la actualizare: " + e.getMessage());
            return "redirect:/members?error=" + id; // Redirecționare cu mesaj de eroare (opțional)
        }

        return "redirect:/members";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}