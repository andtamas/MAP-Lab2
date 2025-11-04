package com.example.Library.service;
import com.example.Library.model.Author;
import com.example.Library.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = new AuthorRepository();
    }

    public void add(Author author) {
        authorRepository.add(author);
    }

    public void update(Author author) {
        authorRepository.update(author);
    }

    public List<Author> getAll() {
        return authorRepository.getList();
    }

    public Author getById(String id) {
        return authorRepository.findById(id);
    }

    public boolean delete(String id) {
        return authorRepository.delete(id);
    }

}
