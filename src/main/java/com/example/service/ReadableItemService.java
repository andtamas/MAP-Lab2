package com.example.service;
import com.example.model.ReadableItem;
import com.example.repository.ReadableItemRepository;
import java.util.List;

public class ReadableItemService {
    private ReadableItemRepository readableItemRepository;

    public ReadableItemService(ReadableItemRepository readableItemRepository) {
        this.readableItemRepository = new ReadableItemRepository();
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
