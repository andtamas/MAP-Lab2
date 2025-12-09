package com.example.Library.repository.old;

import com.example.Library.model.MagazineDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineDetailsRepository extends JpaRepository<MagazineDetails, String> {
}
