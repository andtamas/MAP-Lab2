package com.example.Library.repository;

import com.example.Library.model.MagazineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DEVINE INTERFAȚĂ JPA
@Repository
public interface MagazineDetailsRepository extends JpaRepository<MagazineDetails, String> {
    // String este tipul ID-ului moștenit.
}