package com.example.repository;

import com.example.model.Library;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
    private List<Library> libraryList;

    public LibraryRepository() {
        libraryList = new ArrayList<Library>();
    }

    public void add(Library library) {
        for (int i = 0; i < libraryList.size(); i++) {
            if (libraryList.get(i).getId().equals(library.getId())) {
                throw new IllegalArgumentException("Library with ID " + library.getId() + " already exists");
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
        throw new IllegalArgumentException("Library with ID " + library.getId() + " not found.");
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
        return null;
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
