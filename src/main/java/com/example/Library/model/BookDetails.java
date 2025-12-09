package com.example.Library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_details")
public class BookDetails extends Publication {

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> bookAuthors;

    private String publisher;
    private int year;

    public BookDetails() {}

    public BookDetails(String id, String title, List<ReadableItem> copies, List<BookAuthor> bookAuthors, String publisher, int year) {
        super(id, title, copies);
        this.bookAuthors = bookAuthors;
        this.publisher = publisher;
        this.year = year;
    }

    public List<BookAuthor> getBookAuthors() { return bookAuthors; }
    public void setBookAuthors(List<BookAuthor> bookAuthors) { this.bookAuthors = bookAuthors; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
