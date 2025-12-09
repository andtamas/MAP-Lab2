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

    @GetMapping
    public String listLibraries(Model model) {
        model.addAttribute("libraries", libraryService.getAll());
        return "library/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("library", new Library());
        return "library/form";
    }

    @PostMapping
    public String createLibrary(@ModelAttribute Library library) {
        libraryService.add(library);
        return "redirect:/libraries";
    }

    @GetMapping("/{id}/detail")
    public String viewLibrary(@PathVariable Long id, Model model) {
        model.addAttribute("library", libraryService.getById(id));
        return "library/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("library", libraryService.getById(id));
        return "library/form";
    }

    @PostMapping("/{id}/update")
    public String  updateLibrary(@PathVariable Long id, @ModelAttribute Library library) {
        library.setId(id);
        libraryService.update(library);
        return "redirect:/libraries";
    }

    @PostMapping("/{id}/delete")
    public String deleteLibrary(@PathVariable Long id) {
        libraryService.delete(id);
        return "redirect:/libraries";
    }
}
