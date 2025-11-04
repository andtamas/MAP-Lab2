package com.example.Library.service;
import com.example.Library.model.Library;
import com.example.Library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
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
