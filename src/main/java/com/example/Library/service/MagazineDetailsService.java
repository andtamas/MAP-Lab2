package com.example.Library.service;
import com.example.Library.model.MagazineDetails;
import com.example.Library.repository.MagazineDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MagazineDetailsService {
    private MagazineDetailsRepository magazineDetailsRepository;

    public MagazineDetailsService(MagazineDetailsRepository magazineDetailsRepository) {
        this.magazineDetailsRepository = new MagazineDetailsRepository();
    }

    public void add(MagazineDetails magazineDetails) {
        magazineDetailsRepository.add(magazineDetails);
    }

    public void update(MagazineDetails magazineDetails) {
        magazineDetailsRepository.update(magazineDetails);
    }

    public List<MagazineDetails> getAll() {
        return magazineDetailsRepository.getList();
    }

    public MagazineDetails getById(String id) {
        return magazineDetailsRepository.findById(id);
    }

    public boolean delete(String id) {
        return magazineDetailsRepository.delete(id);
    }

    public List<MagazineDetails> getByPublisher(String publisher) {
        return magazineDetailsRepository.findByPublisher(publisher);
    }

}
