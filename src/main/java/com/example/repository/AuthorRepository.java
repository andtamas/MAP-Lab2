package com.example.repository;
import com.example.model.Author;
import java.util.List;
import java.util.ArrayList;

public class AuthorRepository {
    private List<Author> authorList;

    public AuthorRepository() {
        authorList = new ArrayList<>();
    }

    public void add(Author author) {
        for (int i=0; i<authorList.size(); i++) {
            if (authorList.get(i).getId().equals(author.getId())) {
                throw  new IllegalArgumentException("Author already exists.");
            }
        }
        authorList.add(author);
    }

    public void update(Author author) {
        for (int i=0; i<authorList.size(); i++) {
            if (authorList.get(i).getId().equals(author.getId())) {
                authorList.set(i, author);
            }
        }
        throw new IllegalArgumentException("Author not found.");
    }

    public List<Author> getList() {
        return authorList;
    }

    public Author findById(String id) {
        for (int i=0; i<authorList.size(); i++) {
            if (authorList.get(i).getId().equals(id)) {
                return authorList.get(i);
            }
        }
        return null;
    }

    public boolean delete(String id) {
        for (int i=0; i<authorList.size(); i++) {
            if (authorList.get(i).getId().equals(id)) {
                authorList.remove(i);
                return true;
            }
        }
        return false;
    }
}
