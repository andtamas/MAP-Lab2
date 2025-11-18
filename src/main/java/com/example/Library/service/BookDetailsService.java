package com.example.Library.service;
import com.example.Library.model.BookDetails;
import com.example.Library.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public void add(BookDetails bookDetails) {
        bookDetailsRepository.save(bookDetails);
    }

    public void update(BookDetails bookDetails) {
        bookDetailsRepository.update(bookDetails);
    }

    public List<BookDetails> getAll() {
        return bookDetailsRepository.findAll();
    }

    public BookDetails getById(String id) {
        return bookDetailsRepository.findById(id);
    }

    public void delete(String id) {
        bookDetailsRepository.delete(id);
    }

}
