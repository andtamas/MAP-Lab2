package com.example.Library.controller;

import com.example.Library.model.Publication;
import com.example.Library.service.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public String listPublications(Model model) {
        model.addAttribute("publications", publicationService.getAll());
        return "publication/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("publication", new Publication() {});
        return "publication/form";
    }

    @PostMapping
    public String createPublication(@ModelAttribute Publication publication) {
        publicationService.add(publication);
        return "redirect:/publications";
    }

    @GetMapping("/{id}")
    public String viewPublication(@PathVariable String id, Model model) {
        model.addAttribute("publication", publicationService.getById(id));
        return "publication/detail";
    }

    @PostMapping("/{id}/delete")
    public String deletePublication(@PathVariable String id) {
        publicationService.delete(id);
        return "redirect:/publications";
    }
}
