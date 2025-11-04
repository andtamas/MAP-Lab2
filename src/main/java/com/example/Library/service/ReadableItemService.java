package com.example.Library.service;
import com.example.Library.model.ReadableItem;
import com.example.Library.repository.ReadableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReadableItemService {
    private ReadableItemRepository readableItemRepository;

    public ReadableItemService(ReadableItemRepository readableItemRepository) {
        this.readableItemRepository = readableItemRepository;
    }

    public void add(ReadableItem readableItem) {
        this.readableItemRepository.add(readableItem);
    }

    public void update(ReadableItem readableItem) {
        this.readableItemRepository.update(readableItem);
    }

    public List<ReadableItem> getAll() {
        return readableItemRepository.getList();
    }

    public ReadableItem getById(String id) {
        return readableItemRepository.findById(id);
    }

    public boolean delete(String id) {
        return readableItemRepository.delete(id);
    }
}
