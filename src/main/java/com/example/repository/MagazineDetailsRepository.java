package com.example.repository;
import com.example.model.MagazineDetails;
import java.util.ArrayList;
import java.util.List;

public class MagazineDetailsRepository {
    private List<MagazineDetails> magazineList;

    public MagazineDetailsRepository() {
        magazineList = new ArrayList<>();
    }

    public void add(MagazineDetails magazineDetails) {
        for (int i=0; i<magazineList.size(); i++) {
            if (magazineList.get(i).getId().equals(magazineDetails.getId())) {
                throw new  IllegalArgumentException("Magazine details already exist.");
            }
        }
        magazineList.add(magazineDetails);
    }

    public void update(MagazineDetails magazineDetails) {
        for (int i=0; i<magazineList.size(); i++) {
            if (magazineList.get(i).getId().equals(magazineDetails.getId())) {
                magazineList.set(i, magazineDetails);
            }
        }
        throw  new  IllegalArgumentException("Magazine details not found.");
    }

    public List<MagazineDetails> getList() {
        return magazineList;
    }

    public MagazineDetails findById(String id) {
        for (int i=0; i<magazineList.size(); i++) {
            if (magazineList.get(i).getId().equals(id)) {
                return magazineList.get(i);
            }
        }
        return null;
    }

    public boolean delete(String id) {
        for (int i=0; i<magazineList.size(); i++) {
            if (magazineList.get(i).getId().equals(id)) {
                magazineList.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<MagazineDetails> findByPublisher(String publisher) {
        List<MagazineDetails> result = new ArrayList<>();
        for (int i=0; i<magazineList.size(); i++) {
            if (magazineList.get(i).getPublisher().equals(publisher)) {
                result.add(magazineList.get(i));
            }
        }
        return result;
    }
}
