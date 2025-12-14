package com.example.Library.controller;

import com.example.Library.model.Author;
// Removed unused import: import com.example.Library.model.BookAuthor;
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

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAll());
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
     * MODIFIED: Unwraps Optional<Author> to Author for Thymeleaf to access properties directly.
     */
    @GetMapping("/{id}/detail")
    public String viewAuthor(@PathVariable Long id, Model model) {
        // Find the Author or throw an exception if not found
        Author author = authorService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id: " + id));

        // Add the unwrapped Author object to the model
        model.addAttribute("author", author);
        return "author/detail";
    }

    /**
     * MODIFIED: Unwraps Optional<Author> to Author, which resolves the EL1008E error.
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Find the Author or throw an exception if not found
        Author author = authorService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id: " + id));

        // Add the unwrapped Author object to the model
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