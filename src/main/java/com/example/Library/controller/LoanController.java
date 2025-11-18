package com.example.Library.controller;

import com.example.Library.model.Loan;
import com.example.Library.model.MagazineDetails;
import com.example.Library.service.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public String listLoans(Model model) {
        model.addAttribute("loans", loanService.getAll());
        return "loan/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan/form";
    }

    @PostMapping
    public String createLoan(@ModelAttribute Loan loan) {
        loanService.add(loan);
        return "redirect:/loans";
    }

    @GetMapping("/{id}/detail")
    public String viewLoan(@PathVariable String id, Model model) {
        model.addAttribute("loan", loanService.getById(id));
        return "loan/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("loan", loanService.getById(id));
        return "loan/form";
    }

    @PostMapping("/{id}/update")
    public String updateLoan(@PathVariable String id, @ModelAttribute Loan loan) {
        loan.setId(id);
        loanService.update(loan);
        return "redirect:/loans";
    }

    @PostMapping("/{id}/delete")
    public String deleteLoan(@PathVariable String id) {
        loanService.delete(id);
        return "redirect:/loans";
    }
}
