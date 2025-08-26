package com.day15test.mock;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.day15test.mock.repository.InventoryRepository;
import com.day15test.mock.model.InventoryItem;

// --- InventoryRepositoryTest.java (@DataJpaTest) ---
@DataJpaTest
public class InventoryRepositoryTest {
    @Autowired private TestEntityManager entityManager;
    @Autowired private InventoryRepository inventoryRepository;
    @Test
    void testFindInventoryItemByName() {
        entityManager.persist(new InventoryItem("Laptop", 50));
        Optional<InventoryItem> foundItem = inventoryRepository.findByName("Laptop");
        assertThat(foundItem).isPresent();
    }
}