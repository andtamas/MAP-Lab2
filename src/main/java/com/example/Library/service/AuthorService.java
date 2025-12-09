package com.example.Library.service;
import com.example.Library.model.Author;
import com.example.Library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {
        authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}
