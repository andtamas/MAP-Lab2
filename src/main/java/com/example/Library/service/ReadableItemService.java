package com.example.Library.service;
import com.example.Library.model.ReadableItem;
import com.example.Library.repository.ReadableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        this.readableItemRepository.save(readableItem);
    }

    public List<ReadableItem> findAll() {
        return readableItemRepository.findAll();
    }

    public Optional<ReadableItem> findById(Long id) {
        return readableItemRepository.findById(id);
    }

    public void delete(Long id) {
        readableItemRepository.deleteById(id);
    }
}
