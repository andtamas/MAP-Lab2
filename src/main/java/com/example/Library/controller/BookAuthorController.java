package com.example.Library.controller;

import com.example.Library.model.BookAuthor;
import com.example.Library.service.BookAuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookauthors")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;

    public BookAuthorController(BookAuthorService bookAuthorService) {
        this.bookAuthorService = bookAuthorService;
    }

    @GetMapping
    public String listBookAuthors(Model model) {
        model.addAttribute("bookAuthors", bookAuthorService.getAll());
        return "bookauthor/index";  // templates/bookauthor/index.html
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bookAuthor", new BookAuthor());
        return "bookauthor/form";  // templates/bookauthor/form.html
    }

    @PostMapping
    public String createBookAuthor(@ModelAttribute BookAuthor bookAuthor) {
        bookAuthorService.add(bookAuthor);
        return "redirect:/bookauthors";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("bookAuthor", bookAuthorService.getById(id));
        return "bookauthor/form";
    }

    @PostMapping("/{id}/edit")
    public String updateBookAuthor(@PathVariable Long id, @ModelAttribute BookAuthor bookAuthor) {
        bookAuthorService.update(id, bookAuthor);
        return "redirect:/bookauthors";
    }

    @PostMapping("/{id}/delete")
    public String deleteBookAuthor(@PathVariable Long id) {
        bookAuthorService.delete(id);
        return "redirect:/bookauthors";
    }

    @GetMapping("/{id}/detail")
    public String viewBookAuthor(@PathVariable Long id, Model model) {
        BookAuthor bookAuthor = bookAuthorService.getById(id);
        model.addAttribute("bookAuthor", bookAuthor);
        return "bookauthor/detail";
    }
}
