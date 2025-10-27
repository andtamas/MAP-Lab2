package com.example.model;

import java.util.List;

public class Author {
    private String id;
    private String name;
    private List<BookAuthor> books;

    public Author() {}

    public Author(String id, String name, List<BookAuthor> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookAuthor> getBooks() {
        return books;
    }

    public void setBooks(List<BookAuthor> books) {
        this.books = books;
    }
}
