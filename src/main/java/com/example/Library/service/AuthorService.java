package com.example.Library.service;
import com.example.Library.model.Author;
import com.example.Library.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Adăugat

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void add(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {
        authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public List<Author> getFiltered(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return authorRepository.findByNameContainingIgnoreCase(name.trim());
        }
        return authorRepository.findAll();
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> getById(Long id) {
        return authorRepository.findById(id);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}