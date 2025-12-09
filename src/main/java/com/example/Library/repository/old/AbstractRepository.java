package com.example.Library.repository.old;

import com.example.Library.model.BookDetails;

import java.util.List;

public interface AbstractRepository<T> {
    List<T> findAll();
    T findById(String id);
    BookDetails save(T entity);
    void update(T entity);
    void delete(String id);
}
