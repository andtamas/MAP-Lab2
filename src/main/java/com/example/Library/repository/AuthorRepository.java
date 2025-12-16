package com.example.Library.repository;

import com.example.Library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE (:name IS NULL OR lower(a.name) LIKE lower(concat('%', :name, '%')))")
    List<Author> findByNameContainingIgnoreCase(String name);
}