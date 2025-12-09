package com.example.Library.repository;

import com.example.Library.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookDetailsRepository extends JpaRepository<BookDetails,Long> {
}
