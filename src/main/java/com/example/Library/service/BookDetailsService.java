package com.example.Library.service;

import com.example.Library.model.BookDetails;
import com.example.Library.repository.old.BookDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    // Adaugă un nou BookDetails
    public void add(BookDetails bookDetails) {
        bookDetailsRepository.save(bookDetails);
    }

    // Actualizează un BookDetails existent
    public void update(String id, BookDetails updatedData) {
        Optional<BookDetails> optionalBook = bookDetailsRepository.findById(id);

        if (optionalBook.isPresent()) {
            BookDetails existing = optionalBook.get();

            // actualizează titlul
            existing.setTitle(updatedData.getTitle());

            // actualizează lista de copii
            existing.setCopies(updatedData.getCopies());

            // actualizează lista de BookAuthor
            existing.setBookAuthors(updatedData.getBookAuthors());

            bookDetailsRepository.save(existing);
        } else {
            throw new RuntimeException("BookDetails cu id-ul " + id + " nu a fost găsit.");
        }
    }

    public List<BookDetails> getAll() {
        return bookDetailsRepository.findAll();
    }

    public BookDetails getById(String id) {
        return bookDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookDetails cu id-ul " + id + " nu a fost găsit."));
    }

    public void delete(String id) {
        bookDetailsRepository.deleteById(id);
    }
}
