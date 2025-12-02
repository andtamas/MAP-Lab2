package com.example.Library.controller;

import com.example.Library.model.BookDetails;
import com.example.Library.repository.BookDetailsRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookDetailsRestController {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsRestController(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    // Obține toate cărțile
    @GetMapping
    public List<BookDetails> getAllBooks() {
        return bookDetailsRepository.findAll();
    }

    // Obține o carte după ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDetails> getBookById(@PathVariable String id) {
        return bookDetailsRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Creează o carte nouă
    @PostMapping
    public BookDetails createBook(@Valid @RequestBody BookDetails bookDetails) {
        return bookDetailsRepository.save(bookDetails);
    }

    // Actualizează o carte
    @PutMapping("/{id}")
    public ResponseEntity<BookDetails> updateBook(@PathVariable String id,
                                                  @Valid @RequestBody BookDetails bookDetailsDetails) {
        return bookDetailsRepository.findById(id).map(book -> {
            book.setTitle(bookDetailsDetails.getTitle());
            book.setCopies(bookDetailsDetails.getCopies());
            book.setBookAuthors(bookDetailsDetails.getBookAuthors());
            return ResponseEntity.ok(bookDetailsRepository.save(book));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Șterge o carte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        return bookDetailsRepository.findById(id).map(book -> {
            bookDetailsRepository.delete(book);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
