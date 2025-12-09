package com.example.Library.service;

import com.example.Library.model.BookAuthor;
import com.example.Library.repository.old.BookAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookAuthorService {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public void add(BookAuthor bookAuthor) {
        bookAuthorRepository.save(bookAuthor);
    }

    public void update(Long id, BookAuthor updatedBookAuthor) {
        Optional<BookAuthor> existingOpt = bookAuthorRepository.findById(id);
        existingOpt.ifPresent(existing -> {
            existing.setBook(updatedBookAuthor.getBook());
            existing.setAuthor(updatedBookAuthor.getAuthor());
            bookAuthorRepository.save(existing); // salvăm modificările
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
