package com.example.Library.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;

public class InFileRepository<T> implements AbstractRepository<T> {

    private final ObjectMapper mapper = new ObjectMapper();
    private final File file;
    private final Class<T> type;
    private List<T> data = new ArrayList<>();

    public InFileRepository(String filePath, Class<T> type) {
        this.file = new File(filePath);
        this.type = type;
        load();
    }

    private void load() {
        try {
            if (file.exists()) {
                data = mapper.readValue(file, new TypeReference<List<T>>() {});
            } else {
                data = new ArrayList<>();
                saveToFile();
            }
        } catch (Exception e) { throw new RuntimeException(e); }
    }

    private void saveToFile() {
        try { mapper.writerWithDefaultPrettyPrinter().writeValue(file, data); }
        catch (Exception e) { throw new RuntimeException(e); }
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public T findById(String id) {
        return data.stream()
                .filter(e -> getId(e).equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public void save(T entity) {
        data.add(entity);
        saveToFile();
    }

    @Override
    public void update(T entity) {
        delete(getId(entity));
        save(entity);
    }

    @Override
    public void delete(String id) {
        data.removeIf(e -> getId(e).equals(id));
        saveToFile();
    }

    private String getId(T entity) {
        try {
            return (String) entity.getClass().getMethod("getId").invoke(entity);
        } catch (Exception e) { throw new RuntimeException(e); }
    }
}
