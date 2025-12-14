package com.example.Library.controller;

import com.example.Library.model.Member;
import com.example.Library.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    // CREATE – ID generat automat
    @PostMapping
    public String createMember(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Long libraryId
    ) {
        memberService.create(name, email, libraryId);
        return "redirect:/members";
    }

    // DETAIL
    @GetMapping("/{id}/detail")
    public String viewMember(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getById(id));
        return "member/detail";
    }

    // FORM EDIT
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getById(id));
        return "member/form";
    }

    // UPDATE – fără setId
    @PostMapping("/{id}/update")
    public String updateMember(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email
    ) {
        memberService.update(id, name, email);
        return "redirect:/members";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}
