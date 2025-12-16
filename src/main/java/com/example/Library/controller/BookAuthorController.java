package com.example.Library.controller;

import com.example.Library.model.BookAuthor;
import com.example.Library.service.BookAuthorService;
import com.example.Library.service.BookDetailsService;
import com.example.Library.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookauthors")
public class BookAuthorController {

    private final BookAuthorService bookAuthorService;
    private final BookDetailsService bookDetailsService;
    private final AuthorService authorService;

    public BookAuthorController(BookAuthorService bookAuthorService,
                                BookDetailsService bookDetailsService,
                                AuthorService authorService) {
        this.bookAuthorService = bookAuthorService;
        this.bookDetailsService = bookDetailsService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBookAuthors(Model model) {
        model.addAttribute("bookAuthors", bookAuthorService.getAll());
        return "bookauthor/index";
    }

    // Utilitar pentru a încărca listele de cărți și autori (necesar la form/eroare)
    private void loadFormLists(Model model) {
        model.addAttribute("books", bookDetailsService.getAll());
        model.addAttribute("authors", authorService.getAll());
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bookAuthor", new BookAuthor());
        loadFormLists(model); // Încarcă listele pentru dropdown-uri
        return "bookauthor/form";
    }

    // MODIFICAT: Adăugat @Valid și BindingResult
    @PostMapping
    public String createBookAuthor(@Valid @ModelAttribute("bookAuthor") BookAuthor bookAuthor,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            loadFormLists(model); // Reîncarcă listele în caz de eroare de validare
            return "bookauthor/form";
        }

        try {
            bookAuthorService.create(bookAuthor.getBookId(), bookAuthor.getAuthorId());
        } catch (RuntimeException e) {
            // Gestionează eroarea în caz că ID-ul cărții/autorului nu este găsit
            if (e.getMessage().contains("Book")) {
                bindingResult.rejectValue("bookId", "error.book", e.getMessage());
            } else if (e.getMessage().contains("Author")) {
                bindingResult.rejectValue("authorId", "error.author", e.getMessage());
            } else {
                bindingResult.rejectValue("id", "error.general", "A apărut o eroare la salvare.");
            }
            loadFormLists(model);
            return "bookauthor/form";
        }

        return "redirect:/bookauthors";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("bookAuthor", bookAuthorService.getById(id));
        loadFormLists(model);
        return "bookauthor/form";
    }

    // MODIFICAT: Adăugat @Valid și BindingResult
    @PostMapping("/{id}/edit")
    public String updateBookAuthor(@PathVariable Long id,
                                   @Valid @ModelAttribute BookAuthor bookAuthor,
                                   BindingResult bindingResult,
                                   Model model) {

        if (bindingResult.hasErrors()) {
            loadFormLists(model);
            return "bookauthor/form";
        }

        try {
            bookAuthorService.update(id, bookAuthor);
        } catch (RuntimeException e) {
            System.err.println("Eroare la actualizare BookAuthor: " + e.getMessage());
        }

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