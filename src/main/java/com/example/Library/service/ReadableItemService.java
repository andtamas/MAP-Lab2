package com.example.Library.service;
import com.example.Library.model.ReadableItem;
import com.example.Library.repository.old.ReadableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReadableItemService {
    private ReadableItemRepository readableItemRepository;

    public ReadableItemService(ReadableItemRepository readableItemRepository) {
        this.readableItemRepository = readableItemRepository;
    }

    public void add(ReadableItem readableItem) {
        this.readableItemRepository.save(readableItem);
    }

    public void update(ReadableItem readableItem) {
        this.readableItemRepository.update(readableItem);
    }

    public List<ReadableItem> getAll() {
        return readableItemRepository.findAll();
    }

    public ReadableItem getById(String id) {
        return readableItemRepository.findById(id);
    }

    public void delete(String id) {
        readableItemRepository.delete(id);
    }
}
