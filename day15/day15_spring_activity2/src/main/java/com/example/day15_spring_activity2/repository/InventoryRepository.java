package com.example.day15_spring_activity2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.day15_spring_activity2.model.InventoryItem;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long>  {

    Optional<InventoryItem> findByName(String string);
    
}
