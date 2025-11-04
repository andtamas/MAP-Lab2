package com.example.Library.service;
import com.example.Library.model.BookDetails;
import com.example.Library.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookDetailsService {

    private BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = new BookDetailsRepository();
    }

    public void add(BookDetails bookDetails) {
        bookDetailsRepository.add(bookDetails);
    }

    public void update(BookDetails bookDetails) {
        bookDetailsRepository.update(bookDetails);
    }

    public List<BookDetails> getAll() {
        return bookDetailsRepository.getList();
    }

    public BookDetails getById(String id) {
        return bookDetailsRepository.findById(id);
    }

    public boolean delete(String id) {
        return bookDetailsRepository.delete(id);
    }

    public BookDetails getByTitle(String name) {
        return bookDetailsRepository.findByTitle(name);
    }
}
