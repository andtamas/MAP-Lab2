package com.example.service;
import com.example.model.BookDetails;
import com.example.repository.BookDetailsRepository;
import java.util.List;

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
