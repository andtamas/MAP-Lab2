package com.example.Library.controller;

import com.example.Library.model.Author;
import com.example.Library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Afișează lista de autori, cu opțiune de filtrare după nume.
     */
    @GetMapping
    public String listAuthors(
            Model model,
            @RequestParam(required = false) String name // Adăugat: Parametrul de filtrare
    ) {
        // Utilizează noua metodă filtrată din Service
        model.addAttribute("authors", authorService.getFiltered(name));

        // Adaugă parametrul de filtrare în Model pentru a menține valoarea în formular
        model.addAttribute("filterName", name);

        return "author/index";  // templates/author/index.html
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "author/form";  // templates/author/form.html
    }

    @PostMapping
    public String createAuthor(@ModelAttribute Author author) {
        authorService.add(author);
        return "redirect:/authors";
    }

    /**
     * Afișează detaliile autorului.
     */
    @GetMapping("/{id}/detail")
    public String viewAuthor(@PathVariable Long id, Model model) {
        // Găsește Autorul sau aruncă excepție
        Author author = authorService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id: " + id));

        model.addAttribute("author", author);
        return "author/detail";
    }

    /**
     * Afișează formularul de editare.
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Găsește Autorul sau aruncă excepție
        Author author = authorService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id: " + id));

        model.addAttribute("author", author);
        return "author/form";
    }

    @PostMapping("/{id}/edit")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author) {
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