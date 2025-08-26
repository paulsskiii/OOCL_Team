package com.day15test.testing;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.day15test.testing.model.InventoryItem;
import com.day15test.testing.repository.InventoryRepository;

// --- InventoryRepositoryTest.java (@DataJpaTest) ---
@DataJpaTest
public class IntentoryTest {
    @Autowired private TestEntityManager entityManager;
    @Autowired private InventoryRepository inventoryRepository;
    @Test
    void testFindInventoryItemByName() {
        entityManager.persist(new InventoryItem("Laptop", 50.00));
        Optional<InventoryItem> foundItem = inventoryRepository.findByName("Laptop");
        assert(foundItem).isPresent();
    }
}