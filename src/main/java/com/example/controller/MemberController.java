package com.example.controller;

import com.example.model.Member;
import com.example.service.MemberService;
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
        model.addAttribute("members", memberService.getAllMembers());
        return "member/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        return "member/form";
    }

    @PostMapping
    public String createMember(@ModelAttribute Member member) {
        memberService.addMember(member);
        return "redirect:/members";
    }

    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
        return "redirect:/members";
    }
}
