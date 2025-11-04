package com.example.Library.repository;

import com.example.Library.model.Library;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryRepository {
    private List<Library> libraryList;

    public LibraryRepository() {
        libraryList = new ArrayList<Library>();
    }

    public void add(Library library) {
        for (int i = 0; i < libraryList.size(); i++) {
            if (libraryList.get(i).getId().equals(library.getId())) {
                throw new IllegalArgumentException("Library already exists");
            }
        }
        libraryList.add(library);
    }

    public void update(Library library) {
        for (int i = 0; i < libraryList.size(); i++) {
            if (libraryList.get(i).getId().equals(library.getId())) {
                libraryList.set(i, library);
                return;
            }
        }
        throw new IllegalArgumentException("Library not found.");
    }

    public List<Library> getList() {
        return libraryList;
    }

    public Library findById(String id) {
        for (int i = 0; i < libraryList.size(); i++) {
            if (libraryList.get(i).getId().equals(id)) {
                return libraryList.get(i);
            }
        }
        throw new IllegalArgumentException("Library not found.");
    }

    public boolean delete(String id) {
        for (int i = 0; i < libraryList.size(); i++) {
            if (libraryList.get(i).getId().equals(id)) {
                libraryList.remove(i);
                return true;
            }
        }
        return false;
    }
}
