package com.example.Library.repository.old;

import com.example.Library.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends InFileRepository<Author> {
    public AuthorRepository() {
        super("src/main/resources/data/authors.json", Author.class);
    }
}
