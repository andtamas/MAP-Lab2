package com.example.Library.service;

import com.example.Library.model.Library;
import com.example.Library.repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    // CREATE – ID generat automat
    public void create(String name) {
        Library library = new Library(name);
        libraryRepository.save(library);
    }

    // UPDATE – fără setId, entitatea este gestionată de Hibernate
    public void update(Long id, String name) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));
        library.setName(name);
        // Hibernate gestionează automat modificările
    }

    // READ ALL
    @Transactional(readOnly = true)
    public List<Library> getAll() {
        return libraryRepository.findAll();
    }

    // READ BY ID
    @Transactional(readOnly = true)
    public Library getById(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));
    }

    // DELETE
    public void delete(Long id) {
        libraryRepository.deleteById(id);
    }
}
