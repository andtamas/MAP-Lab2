package com.example.Library.repository;

import java.util.List;

public interface AbstractRepository<T> {
    List<T> findAll();
    T findById(String id);
    void save(T entity);
    void update(T entity);
    void delete(String id);
}
