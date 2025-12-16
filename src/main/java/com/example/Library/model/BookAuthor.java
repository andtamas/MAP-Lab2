package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "book_author")
public class BookAuthor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Câmp tranzient pentru formular (validarea se face aici)
    @Transient
    @NotNull(message = "ID-ul cărții este obligatoriu.")
    private Long bookId;

    // Câmp tranzient pentru formular (validarea se face aici)
    @Transient
    @NotNull(message = "ID-ul autorului este obligatoriu.")
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    // CORECTAT: Am eliminat @NotNull pentru a preveni conflictul de validare la form submission
    private BookDetails book;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    // CORECTAT: Am eliminat @NotNull pentru a preveni conflictul de validare la form submission
    private Author author;

    public BookAuthor() {}

    public BookAuthor(BookDetails book, Author author) {
        this.setBook(book);
        this.setAuthor(author);
    }

    public Long getId() {
        return id;
    }

    public BookDetails getBook() {
        return book;
    }

    public void setBook(BookDetails book) {
        this.book = book;
        if (book != null) {
            this.bookId = book.getId();
        }
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        if (author != null) {
            this.authorId = author.getId();
        }
    }

    // Getters/Setters pentru câmpurile tranziente
    public Long getBookId() {
        if (book != null) {
            return book.getId();
        }
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        if (author != null) {
            return author.getId();
        }
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}