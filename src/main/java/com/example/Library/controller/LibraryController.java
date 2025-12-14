package com.example.Library.controller;

import com.example.Library.model.Library;
import com.example.Library.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/libraries")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    // LIST
    @GetMapping
    public String listLibraries(Model model) {
        model.addAttribute("libraries", libraryService.getAll());
        return "library/index";
    }

    // FORM CREATE
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("library", new Library(""));
        return "library/form";
    }

    // CREATE – ID generat automat
    @PostMapping
    public String createLibrary(@RequestParam String name) {
        libraryService.create(name);
        return "redirect:/libraries";
    }

    // DETAIL
    @GetMapping("/{id}/detail")
    public String viewLibrary(@PathVariable Long id, Model model) {
        model.addAttribute("library", libraryService.getById(id));
        return "library/detail";
    }

    // FORM EDIT
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("library", libraryService.getById(id));
        return "library/form";
    }

    // UPDATE – FĂRĂ setId
    @PostMapping("/{id}/update")
    public String updateLibrary(
            @PathVariable Long id,
            @RequestParam String name
    ) {
        libraryService.update(id, name);
        return "redirect:/libraries";
    }

    // DELETE
    @PostMapping("/{id}/delete")
    public String deleteLibrary(@PathVariable Long id) {
        libraryService.delete(id);
        return "redirect:/libraries";
    }
}
