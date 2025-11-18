package com.example.Library.controller;

import com.example.Library.model.MagazineDetails;
import com.example.Library.service.MagazineDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/magazines")
public class MagazineDetailsController {

    private final MagazineDetailsService magazineDetailsService;

    public MagazineDetailsController(MagazineDetailsService magazineDetailsService) {
        this.magazineDetailsService = magazineDetailsService;
    }

    @GetMapping
    public String listMagazines(Model model) {
        model.addAttribute("magazines", magazineDetailsService.getAll());
        return "magazine/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("magazine", new MagazineDetails());
        return "magazine/form";
    }

    @PostMapping
    public String createMagazine(@ModelAttribute MagazineDetails magazine) {
        magazineDetailsService.add(magazine);
        return "redirect:/magazines";
    }

    @GetMapping("/{id}/detail")
    public String viewMagazine(@PathVariable String id, Model model) {
        model.addAttribute("magazine", magazineDetailsService.getById(id));
        return "magazine/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("magazine", magazineDetailsService.getById(id));
        return "magazine/form";
    }

    @PostMapping("/{id}/update")
    public String updateMagazine(@PathVariable String id, @ModelAttribute MagazineDetails magazine) {
        magazine.setId(id);
        magazineDetailsService.update(magazine);
        return "redirect:/magazines";
    }

    @PostMapping("/{id}/delete")
    public String deleteMagazine(@PathVariable String id) {
        magazineDetailsService.delete(id);
        return "redirect:/magazines";
    }
}
