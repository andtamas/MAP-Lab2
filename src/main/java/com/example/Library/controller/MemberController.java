package com.example.Library.controller;

import com.example.Library.model.Member;
import com.example.Library.service.MemberService;
import com.example.Library.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // LIST - MODIFICAT pentru a accepta și procesa filtrele
    @GetMapping
    public String listMembers(
            Model model,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long libraryId
    ) {
        // Obține membrii filtrați
        model.addAttribute("members", memberService.getFiltered(id, name, libraryId));

        // Adaugă atributele de filtrare în Model pentru a menține valorile în formular
        model.addAttribute("filterId", id);
        model.addAttribute("filterName", name);
        model.addAttribute("filterLibraryId", libraryId);

        // Adaugă lista de biblioteci pentru dropdown-ul de filtrare
        model.addAttribute("allLibraries", libraryService.getAll());

        return "member/index";
    }

    // ... (restul metodelor createMember, viewMember, updateMember, deleteMember rămân neschimbate în structura de bază)

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("libraries", libraryService.getAll());
        return "member/form";
    }

    @PostMapping
    public String createMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("libraries", libraryService.getAll());
            return "member/form";
        }

        try {
            memberService.create(member.getName(), member.getEmail(), member.getLibraryId());
        } catch (RuntimeException e) {
            bindingResult.rejectValue("libraryId", "error.member", e.getMessage());
            model.addAttribute("libraries", libraryService.getAll());
            return "member/form";
        }

        return "redirect:/members";
    }

    @GetMapping("/{id}/detail")
    public String viewMember(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getById(id));
        return "member/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getById(id));
        model.addAttribute("libraries", libraryService.getAll());
        return "member/form";
    }

    @PostMapping("/{id}/update")
    public String updateMember(
            @PathVariable Long id,
            @Valid @ModelAttribute("member") Member member,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("libraries", libraryService.getAll());
            return "member/form";
        }

        try {
            memberService.update(id, member.getName(), member.getEmail());
        } catch (RuntimeException e) {
            System.err.println("Eroare la actualizare: " + e.getMessage());
            return "redirect:/members?error=" + id;
        }

        return "redirect:/members";
    }

    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}