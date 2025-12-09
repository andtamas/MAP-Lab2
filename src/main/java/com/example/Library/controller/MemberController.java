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

    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.getAll());
        return "member/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        return "member/form";
    }

    @PostMapping
    public String createMember(@ModelAttribute Member member) {
        memberService.add(member);
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
        return "member/form";
    }

    @PostMapping("/{id}/update")
    public String updateMember(@PathVariable Long id, @ModelAttribute Member member) {
        member.setId(id);
        memberService.update(member);
        return "redirect:/members";
    }

    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/members";
    }
}
