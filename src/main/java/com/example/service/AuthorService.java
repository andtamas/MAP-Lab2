package com.example.service;
import com.example.model.Author;
import com.example.repository.AuthorRepository;
import java.util.List;


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
