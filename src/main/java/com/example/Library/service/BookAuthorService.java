package com.example.Library.service;
import com.example.Library.model.BookAuthor;
import com.example.Library.repository.BookAuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookAuthorService {

    private BookAuthorRepository bookAuthorRepository;

    public BookAuthorService(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = new BookAuthorRepository();
    }

    public void add(BookAuthor bookAuthor) {
        bookAuthorRepository.add(bookAuthor);
    }

    public void update(BookAuthor bookAuthor) {
        bookAuthorRepository.update(bookAuthor);
    }

    public List<BookAuthor> getAll() {
        return bookAuthorRepository.getList();
    }

    public BookAuthor getById(String id) {
        return bookAuthorRepository.findById(id);
    }

    public boolean delete(String id) {
        return bookAuthorRepository.delete(id);
    }
}
