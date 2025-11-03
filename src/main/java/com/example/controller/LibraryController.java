package com.example.controller;

import com.example.model.Library;
import com.example.service.LibraryService;
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
        model.addAttribute("libraries", libraryService.getAllLibraries());
        return "library/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("library", new Library());
        return "library/form";
    }

    @PostMapping
    public String createLibrary(@ModelAttribute Library library) {
        libraryService.addLibrary(library);
        return "redirect:/libraries";
    }

    @PostMapping("/{id}/delete")
    public String deleteLibrary(@PathVariable String id) {
        libraryService.deleteLibrary(id);
        return "redirect:/libraries";
    }
}
