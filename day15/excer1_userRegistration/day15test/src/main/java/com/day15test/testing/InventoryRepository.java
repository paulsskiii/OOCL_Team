package com.day15test.testing;

import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository {
    Optional<InventoryItem> findByName(String name);

}
