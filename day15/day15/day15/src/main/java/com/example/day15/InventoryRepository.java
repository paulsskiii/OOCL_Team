package com.example.day15;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.day15.model.InventoryItem;

@Repository
public interface InventoryRepository {

    Optional<InventoryItem> findByName(String string);

}
