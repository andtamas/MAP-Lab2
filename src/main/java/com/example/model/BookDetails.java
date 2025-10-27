package com.example.model;

import java.util.List;

public class BookDetails extends Publication {
    private List<BookAuthor> bookAuthors;

    public BookDetails() {}

    public BookDetails(String id, String title, List<ReadableItem> copies, List<BookAuthor> bookAuthors) {
        super(id, title, copies);
        this.bookAuthors = bookAuthors;
    }

    public List<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
