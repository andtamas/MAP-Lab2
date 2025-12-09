package com.example.Library.repository;

import com.example.Library.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface LibraryRepository extends JpaRepository<Library,Long> {
}
