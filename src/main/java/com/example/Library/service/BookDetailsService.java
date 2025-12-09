package com.example.Library.service;

import com.example.Library.model.BookDetails;
import com.example.Library.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public void save(BookDetails bookDetails) {
        bookDetailsRepository.save(bookDetails);
    }

    public void update(Long id, BookDetails updatedData) {
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

    public List<BookDetails> findAll() {
        return bookDetailsRepository.findAll();
    }

    public BookDetails findById(Long id) {
        return bookDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookDetails cu id-ul " + id + " nu a fost găsit."));
    }

    public void delete(Long id) {
        bookDetailsRepository.deleteById(id);
    }
}
