package com.example.Library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_details")
public class BookDetails extends Publication {

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> bookAuthors;

    private String author;
    private String publisher;
    private Integer year;

    public BookDetails() {}

    public BookDetails(String id, String title, List<ReadableItem> copies,
                       List<BookAuthor> bookAuthors, String author, String publisher, Integer year) {
        super(id, title, copies);
        this.bookAuthors = bookAuthors;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

    public List<BookAuthor> getBookAuthors() { return bookAuthors; }
    public void setBookAuthors(List<BookAuthor> bookAuthors) { this.bookAuthors = bookAuthors; }

    // ---- NOILE getter/setter ----
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
}
