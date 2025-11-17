package com.example.Library.repository;

import com.example.Library.model.MagazineDetails;
import org.springframework.stereotype.Repository;

@Repository
public class MagazineDetailsRepository extends InFileRepository<MagazineDetails> {
    public MagazineDetailsRepository() {
        super("src/main/resources/data/magazines.json", MagazineDetails.class);
    }
}
