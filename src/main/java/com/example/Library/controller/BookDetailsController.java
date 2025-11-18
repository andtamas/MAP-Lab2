package com.example.Library.controller;

import com.example.Library.model.BookDetails;
import com.example.Library.service.BookDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookDetailsController {

    private final BookDetailsService bookDetailsService;

    public BookDetailsController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookDetailsService.getAll());
        return "book/index";  // templates/book/index.html
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new BookDetails());
        return "book/form";  // templates/book/form.html
    }

    @PostMapping
    public String createBook(@ModelAttribute BookDetails book) {
        bookDetailsService.add(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/detail")
    public String viewBook(@PathVariable String id, Model model) {
        BookDetails book = bookDetailsService.getById(id);
        model.addAttribute("book", book);
        return "book/detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        BookDetails book = bookDetailsService.getById(id);
        model.addAttribute("book", book);
        return "book/form";
    }

    @PostMapping("/{id}/edit")
    public String updateBook(@PathVariable String id, @ModelAttribute BookDetails book) {
        book.setId(id);
        bookDetailsService.update(book);
        return "redirect:/books";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable String id) {
        bookDetailsService.delete(id);
        return "redirect:/books";
    }
}
