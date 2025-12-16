// src/main/java/com/example/Library/service/BookAuthorService.java
package com.example.Library.service;

import com.example.Library.model.Author;
import com.example.Library.model.BookAuthor;
import com.example.Library.model.BookDetails;
import com.example.Library.repository.BookAuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;
    private final BookDetailsService bookDetailsService; // Adăugat
    private final AuthorService authorService;           // Adăugat

    public BookAuthorService(BookAuthorRepository bookAuthorRepository,
                             BookDetailsService bookDetailsService,
                             AuthorService authorService) { // Constructor modificat
        this.bookAuthorRepository = bookAuthorRepository;
        this.bookDetailsService = bookDetailsService;
        this.authorService = authorService;
    }

    // NOU: Metodă de creare care ia ID-uri și convertește în entități
    public void create(Long bookId, Long authorId) {
        // Presupunem că getById din BookDetailsService aruncă excepție
        BookDetails book = bookDetailsService.getById(bookId);

        // getById din AuthorService returnează Optional
        Author author = authorService.getById(authorId)
                .orElseThrow(() -> new RuntimeException("Author with ID " + authorId + " not found"));

        BookAuthor bookAuthor = new BookAuthor(book, author);
        bookAuthorRepository.save(bookAuthor);
    }

    // Metoda veche 'add' a fost redenumită/folosită intern. Vom folosi logica de mai sus.
    public void save(BookAuthor bookAuthor) {
        bookAuthorRepository.save(bookAuthor);
    }


    public void update(Long id, BookAuthor updatedBookAuthor) {
        Optional<BookAuthor> existingOpt = bookAuthorRepository.findById(id);
        existingOpt.ifPresent(existing -> {
            // Logica de update folosind IDs
            if (updatedBookAuthor.getBookId() != null) {
                BookDetails book = bookDetailsService.getById(updatedBookAuthor.getBookId());
                existing.setBook(book);
            }
            if (updatedBookAuthor.getAuthorId() != null) {
                Author author = authorService.getById(updatedBookAuthor.getAuthorId())
                        .orElseThrow(() -> new RuntimeException("Author with ID " + updatedBookAuthor.getAuthorId() + " not found"));
                existing.setAuthor(author);
            }
            bookAuthorRepository.save(existing);
        });
    }

    public List<BookAuthor> getAll() {
        return bookAuthorRepository.findAll();
    }

    public BookAuthor getById(Long id) {
        return bookAuthorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        bookAuthorRepository.deleteById(id);
    }
}