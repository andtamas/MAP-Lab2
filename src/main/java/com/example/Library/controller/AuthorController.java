package com.example.Library.controller;

import com.example.Library.model.Author;
import com.example.Library.model.BookAuthor;
import com.example.Library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/detail")
    public String viewAuthor(@PathVariable String id, Model model) {
        Author author = authorService.getById(id);
        model.addAttribute("author", author);
        return "author/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute("author", authorService.getById(id));
        return "author/form";
    }

    @PostMapping("/{id}/edit")
    public String updateBookAuthor(@PathVariable String id, @ModelAttribute Author author) {
        author.setId(id);
        authorService.update(author);
        return "redirect:/authors";
    }

    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable String id) {
        authorService.delete(id);
        return "redirect:/authors";
    }
}
