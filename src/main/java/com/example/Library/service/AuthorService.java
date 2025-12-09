package com.example.Library.service;
import com.example.Library.model.Author;
import com.example.Library.repository.old.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        authorRepository.update(author);
    }

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getById(String id) {
        return authorRepository.findById(id);
    }

    public void delete(String id) {
        authorRepository.delete(id);
    }

}
