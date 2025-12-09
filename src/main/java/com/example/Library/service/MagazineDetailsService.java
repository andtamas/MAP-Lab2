package com.example.Library.service;

import com.example.Library.model.MagazineDetails;
import com.example.Library.repository.MagazineDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagazineDetailsService {

    private final MagazineDetailsRepository magazineDetailsRepository;

    public MagazineDetailsService(MagazineDetailsRepository magazineDetailsRepository) {
        this.magazineDetailsRepository = magazineDetailsRepository;
    }

    // CREATE
    public void add(MagazineDetails magazineDetails) {
        magazineDetailsRepository.save(magazineDetails);
    }

    // UPDATE (CORECT)
    public void update(Long id, MagazineDetails newData) {
        Optional<MagazineDetails> optional = magazineDetailsRepository.findById(id);

        if (optional.isPresent()) {
            MagazineDetails magazine = optional.get();

            magazine.setTitle(newData.getTitle());
            magazine.setPublisher(newData.getPublisher());
            magazine.setYear(newData.getYear());

            magazineDetailsRepository.save(magazine);
        }
    }

    // READ ALL
    public List<MagazineDetails> findAll() {
        return magazineDetailsRepository.findAll();
    }

    // READ BY ID
    public MagazineDetails findById(Long id) {
        return magazineDetailsRepository.findById(id).orElse(null);
    }

    // DELETE
    public void delete(Long id) {
        magazineDetailsRepository.deleteById(id);
    }
}
