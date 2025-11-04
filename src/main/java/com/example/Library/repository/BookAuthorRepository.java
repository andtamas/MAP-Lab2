package com.example.Library.repository;
import com.example.Library.model.BookAuthor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
@Repository
public class BookAuthorRepository {
    private List<BookAuthor> links;

    public BookAuthorRepository() {
        links = new ArrayList<>();
    }

    public void add(BookAuthor link) {
        for (int i = 0; i< links.size(); i++){
            if (links.get(i).getId().equals(link.getId())) {
                throw  new IllegalArgumentException("Link already exists.");
            }
        }
        links.add(link);
    }

    public void update(BookAuthor link) {
        for (int i = 0; i< links.size(); i++){
            if (links.get(i).getId().equals(link.getId())) {
                links.set(i, link);
            }
        }
        throw new IllegalArgumentException("Link not found.");
    }

    public List<BookAuthor> getList() {
        return links;
    }

    public BookAuthor findById(String id) {
        for (int i = 0; i< links.size(); i++){
            if (links.get(i).getId().equals(id)) {
                return links.get(i);
            }
        }
        return null;
    }

    public boolean delete(String id) {
        for (int i = 0; i< links.size(); i++){
            if (links.get(i).getId().equals(id)) {
                links.remove(i);
                return true;
            }
        }
        return false;
    }
}
