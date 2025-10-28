package com.example.repository;
import com.example.model.BookAuthor;
import java.util.List;
import java.util.ArrayList;
public class BookAuthorRepository {
    private List<BookAuthor> links;

    public BookAuthorRepository() {
        links = new ArrayList<>();
    }

    public void save(BookAuthor link) {
        for (int i = 0; i< links.size(); i++){
            if (links.get(i).getId().equals(link.getId())) {
                links.set(i, link);
            }
        }
        links.add(link);
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
