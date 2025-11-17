package com.example.Library.repository;

import com.example.Library.model.BookDetails;
import org.springframework.stereotype.Repository;

@Repository
public class BookDetailsRepository extends InFileRepository<BookDetails> {
    public BookDetailsRepository() {
        super("src/main/resources/data/books.json", BookDetails.class);
    }
}
