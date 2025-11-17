package com.example.Library.repository;

import com.example.Library.model.ReadableItem;
import org.springframework.stereotype.Repository;

@Repository
public class ReadableItemRepository extends InFileRepository<ReadableItem> {
    public ReadableItemRepository() {
        super("src/main/resources/data/readableItems.json", ReadableItem.class);
    }
}
