package com.example.Library.repository;

import com.example.Library.model.ReadableItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ReadableItemRepository {
    private List<ReadableItem> itemList;

    public ReadableItemRepository() {
        itemList = new ArrayList<>();
    }

    public void add(ReadableItem item) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equals(item.getId())) {
                throw new  IllegalArgumentException("Item already exists.");
            }
        }
        itemList.add(item);
    }

    public void update(ReadableItem item) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equals(item.getId())) {
                itemList.set(i, item);
            }
        }
        throw new IllegalArgumentException("Item not found.");
    }

    public List<ReadableItem> getList() {
        return itemList;
    }

    public ReadableItem findById(String id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equals(id)) {
                return itemList.get(i);
            }
        }
        return null;
    }

    public boolean delete (String id) {
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getId().equals(id)) {
                itemList.remove(i);
                return true;
            }
        }
        return false;
    }

}
