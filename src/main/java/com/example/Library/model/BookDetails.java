package com.example.Library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_details")
public class BookDetails extends Publication {

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> bookAuthors;

    public BookDetails() {}

    public BookDetails(String id, String title, List<ReadableItem> copies, List<BookAuthor> bookAuthors) {
        super(id, title, copies);
        this.bookAuthors = bookAuthors;
    }

    public List<BookAuthor> getBookAuthors() { return bookAuthors; }
    public void setBookAuthors(List<BookAuthor> bookAuthors) { this.bookAuthors = bookAuthors; }
}
