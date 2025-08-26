package com.day15test.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day15test.test.model.InventoryItem;

@Repository
public interface InventoryRepository extends JpaRepository <InventoryItem, Long> {
    Optional<InventoryItem> findByName(String name);    
}
