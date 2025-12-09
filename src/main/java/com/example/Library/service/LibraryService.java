package com.example.Library.service;
import com.example.Library.model.Library;
import com.example.Library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        libraryRepository.save(library);
    }

    public List<Library> getAll() {
        return libraryRepository.findAll();
    }

    public Optional<Library> getById(Long id) {
       return libraryRepository.findById(id);
    }

    public void delete(Long id) {libraryRepository.deleteById(id);
    }
}
