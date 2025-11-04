package com.example.Library.model;

import java.util.List;

public class BookDetails extends Publication {
    private String genre;
    private List<BookAuthor> bookAuthors;

    public BookDetails() {}

    public BookDetails(String id, String title, String genre, List<ReadableItem> copies, List<BookAuthor> bookAuthors) {
        super(id, title, copies);
        this.genre = genre; // extra
        this.bookAuthors = bookAuthors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<BookAuthor> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(List<BookAuthor> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
