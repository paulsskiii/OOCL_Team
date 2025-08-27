package com.example.day15;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    InventoryItem findByName(String name);
    InventoryItem save(InventoryItem inventory);
}
