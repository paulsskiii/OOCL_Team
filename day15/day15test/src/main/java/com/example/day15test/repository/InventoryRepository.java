package com.example.day15test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day15test.model.InventoryItem;



@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long>{
    Optional<InventoryItem> findByName(String name);
}
