package com.example.Library.controller;

import com.example.Library.model.BookDetails;
import com.example.Library.service.BookDetailsService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDetailsService bookDetailsService;

    public BookController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    // LISTARE: Mapează la /books și folosește book/index.html
    @GetMapping
    public String listBooks(Model model) {
        // Obține toate cărțile folosind serviciul
        model.addAttribute("books", bookDetailsService.getAll());
        return "book/index";
    }

    // CREATE FORM: Mapează la /books/new
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        // Obiect gol pentru formular
        model.addAttribute("book", new BookDetails());
        return "book/form";
    }

    // CREATE ACTION: Mapează la POST /books
    @PostMapping
    public String createBook(@Valid @ModelAttribute("book") BookDetails book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/form";
        }

        // ID-ul va fi generat automat de baza de date
        bookDetailsService.add(book);
        return "redirect:/books";
    }

    // DETAIL: Mapează la /books/{id}/detail
    @GetMapping("/{id}/detail")
    public String viewBook(@PathVariable Long id, Model model) {
        BookDetails book = bookDetailsService.getById(id);
        // Aruncă excepție dacă nu este găsită (opțional, depinde de implementarea service-ului)
        if (book == null) {
            throw new IllegalArgumentException("Invalid book Id: " + id);
        }
        model.addAttribute("book", book);
        return "book/detail";
    }

    // EDIT FORM: Mapează la /books/{id}/edit
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        BookDetails book = bookDetailsService.getById(id);
        if (book == null) {
            throw new IllegalArgumentException("Invalid book Id: " + id);
        }
        model.addAttribute("book", book);
        return "book/form";
    }

    // UPDATE ACTION: Mapează la POST /books/{id}/edit
    @PostMapping("/{id}/edit")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute("book") BookDetails book,
                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/form";
        }

        bookDetailsService.update(id, book);
        return "redirect:/books";
    }

    // DELETE ACTION: Mapează la POST /books/{id}/delete
    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        bookDetailsService.delete(id);
        return "redirect:/books";
    }
}