package com.example.Library.service;

import com.example.Library.model.BookDetails;
import com.example.Library.repository.BookDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class BookDetailsService {

    private final BookDetailsRepository bookDetailsRepository;

    public BookDetailsService(BookDetailsRepository bookDetailsRepository) {
        this.bookDetailsRepository = bookDetailsRepository;
    }

    public BookDetails updateBook(Long id, BookDetails bookDetailsDetails) {
        BookDetails book = bookDetailsRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));

        book.setTitle(bookDetailsDetails.getTitle());
        book.setAuthor(bookDetailsDetails.getAuthor());
        book.setPublisher(bookDetailsDetails.getPublisher());
        book.setYear(bookDetailsDetails.getYear());

        return bookDetailsRepository.save(book); // aici se face update
    }

    public BookDetails getBookById(Long id) {
        return bookDetailsRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    public void deleteBook(Long id) {
        BookDetails book = bookDetailsRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
        bookDetailsRepository.delete(book);
    }
}
