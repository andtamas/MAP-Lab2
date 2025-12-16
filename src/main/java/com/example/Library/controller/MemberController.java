package com.example.Library.controller;

import com.example.Library.model.Member;
import com.example.Library.service.MemberService;
import com.example.Library.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Asigurați-vă că acest import există
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final LibraryService libraryService;

    public MemberController(MemberService memberService, LibraryService libraryService) {
        this.memberService = memberService;
        this.libraryService = libraryService;
    }

    // LIST (Metodă corectă)
    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.getAll());
        return "member/index";
    }

    // FORM CREATE (Metodă corectă)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("libraries", libraryService.getAll());
        return "member/form";
    }

    // CREATE – CORECTAT: Adăugat 'Model model' în parametri
    @PostMapping
    public String createMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            // Acum 'model' este accesibil
            model.addAttribute("libraries", libraryService.getAll());
            return "member/form";
        }

        try {
            memberService.create(member.getName(), member.getEmail(), member.getLibraryId());
        } catch (RuntimeException e) {
            bindingResult.rejectValue("libraryId", "error.member", e.getMessage());
            // Acum 'model' este accesibil
            model.addAttribute("libraries", libraryService.getAll());
            return "member/form";
        }

        return "redirect:/members";
    }

    // DETAIL (Fără schimbări)
    @GetMapping("/{id}/detail")
    public String viewMember(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getById(id));
        return "member/detail";
    }

    // FORM EDIT (Metodă corectă)
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getById(id));
        model.addAttribute("libraries", libraryService.getAll());
        return "member/form";
    }

    // UPDATE – CORECTAT: Adăugat 'Model model' în parametri
    @PostMapping("/{id}/update")
    public String updateMember(
            @PathVariable Long id,
            @Valid @ModelAttribute("member") Member member,
            BindingResult bindingResult,
            Model model // Adăugat: face obiectul 'model' accesibil
    ) {
        if (bindingResult.hasErrors()) {
            // Acum 'model' este accesibil
            model.addAttribute("libraries", libraryService.getAll());
            return "member/form";
        }

        try {
            memberService.update(id, member.getName(), member.getEmail());
        } catch (RuntimeException e) {
            System.err.println("Eroare la actualizare: " + e.getMessage());
            // Dacă doriți să afișați eroarea în formularul de editare,
            // ar trebui să adăugați logica de reîncărcare a bibliotecilor aici.
            return "redirect:/members?error=" + id;
        }

        return "redirect:/members";
    }

    // DELETE (Fără schimbări)
    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}