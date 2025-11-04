package com.example.service;
import com.example.model.Library;
import com.example.repository.LibraryRepository;

import java.util.List;


public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = new LibraryRepository();
    }

    public void add(Library library) {
        libraryRepository.add(library);
    }

    public void update(Library library) {
        libraryRepository.update(library);
    }

    public List<Library> getAll() {
        return libraryRepository.getList();
    }

    public Library getById(String id) {
       return libraryRepository.findById(id);
    }

    public boolean delete(String id) {
        return libraryRepository.delete(id);
    }
}
