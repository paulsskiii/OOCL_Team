// --- InventoryRepositoryTest.java (@DataJpaTest) ---
package com.example.day15_spring_activity2;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.day15_spring_activity2.model.InventoryItem;
import com.example.day15_spring_activity2.repository.InventoryRepository;

@DataJpaTest
public class InventoryRepositoryTest {
    @Autowired private TestEntityManager entityManager;
    @Autowired private InventoryRepository inventoryRepository;
    
    @Test
    void testFindInventoryItemByName() {
        entityManager.persist(new InventoryItem("Laptop", 50));
        Optional<InventoryItem> foundItem = inventoryRepository.findByName("Laptop");
        assert(foundItem).isPresent();
    }
}