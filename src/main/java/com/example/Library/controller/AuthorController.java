package com.example.Library.controller;

import com.example.Library.model.Author;
import com.example.Library.service.AuthorService;
import jakarta.validation.Valid; // NECESAR pentru a declanșa validarea
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // NECESAR pentru a prinde erorile
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String listAuthors(
            Model model,
            @RequestParam(required = false) String name
    ) {
        model.addAttribute("authors", authorService.getFiltered(name));
        model.addAttribute("filterName", name);
        return "author/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/form";
    }

    // METODĂ MODIFICATĂ: Include @Valid și BindingResult
    @PostMapping
    public String createAuthor(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult) {

        // 1. Verifică dacă există erori de validare (e.g., câmpul 'name' este @NotBlank și este gol)
        if (bindingResult.hasErrors()) {
            // Dacă există erori, returnează formularul.
            // Thymeleaf va folosi 'bindingResult' pentru a afișa mesajele de eroare.
            return "author/form";
        }

        // 2. Dacă nu există erori, salvează și redirecționează către lista de autori
        authorService.add(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/detail")
    public String viewAuthor(@PathVariable Long id, Model model) {
        Author author = authorService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id: " + id));

        model.addAttribute("author", author);
        return "author/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Author author = authorService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id: " + id));

        model.addAttribute("author", author);
        return "author/form";
    }

    // MODIFICAT: Adaugă @Valid și BindingResult și la update
    @PostMapping("/{id}/edit")
    public String updateAuthor(@PathVariable Long id, @Valid @ModelAttribute Author author, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "author/form";
        }

        author.setId(id);
        authorService.update(author);
        return "redirect:/authors";
    }

    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/authors";
    }
}