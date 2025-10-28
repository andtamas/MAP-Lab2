package com.example.repository;
import com.example.model.BookDetails;
import java.util.List;
import java.util.ArrayList;

public class BookDetailsRepository {
    private List<BookDetails> bookList;

    public BookDetailsRepository() {
        bookList = new ArrayList<>();
    }

    public void save(BookDetails bookDetails) {
        for (int i=0;i<bookList.size();i++){
            if (bookList.get(i).getId().equals(bookDetails.getId())) {
                bookList.set(i,bookDetails);
            }
        }
        bookList.add(bookDetails);
    }

    public List<BookDetails> getList() {
        return bookList;
    }

    public BookDetails findById(String id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                return bookList.get(i);
            }
        }
        return null;
    }

    public boolean delete(String id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }

    public BookDetails findByTitle(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equals(title)) {
                return bookList.get(i);
            }
        }
        return null;
    }
}
