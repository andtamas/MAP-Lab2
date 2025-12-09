package com.example.Library.service;
import com.example.Library.model.Library;
import com.example.Library.repository.old.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    private LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void add(Library library) {
        libraryRepository.save(library);
    }

    public void update(Library library) {
        libraryRepository.update(library);
    }

    public List<Library> getAll() {
        return libraryRepository.findAll();
    }

    public Library getById(String id) {
       return libraryRepository.findById(id);
    }

    public void delete(String id) {libraryRepository.delete(id);
    }
}
