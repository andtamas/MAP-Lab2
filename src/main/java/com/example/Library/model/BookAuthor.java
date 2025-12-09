package com.example.Library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull; // Adăugat

@Entity
@Table(name = "book_author")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull(message = "Cartea este obligatorie.") // Adăugat
    private BookDetails book;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @NotNull(message = "Autorul este obligatoriu.") // Adăugat
    private Author author;

    public BookAuthor() {}

    public BookAuthor(BookDetails book, Author author) {
        this.book = book;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    // setId omis pentru ID-uri generate automat

    public BookDetails getBook() {
        return book;
    }

    public void setBook(BookDetails book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}