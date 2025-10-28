package com.example.service;
import com.example.model.Library;
import com.example.repository.LibraryRepository;

import java.util.List;


public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = new LibraryRepository();
    }

    public void addLibrary(Library library) {
        libraryRepository.add(library);
    }

    public void updateLibrary(Library library) {
        libraryRepository.update(library);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.getList();
    }

    public Library getLibraryById(String id) {
       return libraryRepository.findById(id);
    }

    public boolean deleteLibrary(String id) {
        return libraryRepository.delete(id);
    }
}
