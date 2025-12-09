package com.example.Library.repository.old;

import com.example.Library.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
    // Nu mai trebuie nicio metodă customă update
}
