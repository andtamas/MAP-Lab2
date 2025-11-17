package com.example.Library.repository;

import com.example.Library.model.Library;
import org.springframework.stereotype.Repository;

@Repository
public class LibraryRepository extends InFileRepository<Library> {

    public LibraryRepository() {
        super("src/main/resources/data/libraries.json", Library.class);
    }
}
