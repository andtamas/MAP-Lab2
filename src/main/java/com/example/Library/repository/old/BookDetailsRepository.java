package com.example.Library.repository.old;

import com.example.Library.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetails, String> {
    // JpaRepository oferă deja metode precum save, findById, findAll, delete etc.
}
