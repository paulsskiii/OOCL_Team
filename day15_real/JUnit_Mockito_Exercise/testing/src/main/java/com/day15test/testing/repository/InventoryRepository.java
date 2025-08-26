package com.day15test.testing.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.day15test.testing.model.InventoryItem;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, String>{
    Optional<InventoryItem> findByName(String origin);
}
