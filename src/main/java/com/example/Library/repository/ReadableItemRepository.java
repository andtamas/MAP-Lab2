package com.example.Library.repository;

import com.example.Library.model.ReadableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReadableItemRepository extends JpaRepository<ReadableItem,Long>{
}
