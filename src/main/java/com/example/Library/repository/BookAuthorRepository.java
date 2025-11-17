package com.example.Library.repository;

import com.example.Library.model.BookAuthor;
import org.springframework.stereotype.Repository;

@Repository
public class BookAuthorRepository extends InFileRepository<BookAuthor> {
    public BookAuthorRepository() {
        super("src/main/resources/data/bookAuthors.json", BookAuthor.class);
    }
}
