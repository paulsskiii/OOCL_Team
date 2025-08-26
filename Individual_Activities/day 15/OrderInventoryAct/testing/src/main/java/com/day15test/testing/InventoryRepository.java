package com.day15test.testing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {
    Optional<InventoryItem> findByName(String name);
}
