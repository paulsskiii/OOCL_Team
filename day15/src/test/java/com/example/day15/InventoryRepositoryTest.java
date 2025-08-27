package com.example.day15;
// --- InventoryRepositoryTest.java (@DataJpaTest) ---

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@DataJpaTest
public class InventoryRepositoryTest {
    @Autowired private TestEntityManager entityManager;
    @Autowired private InventoryRepository inventoryRepository;
    
    @Test
    void testFindInventoryItemByName() {
        entityManager.persist(new InventoryItem("Laptop", 50));
        Optional<InventoryItem> foundItem = Optional.of(inventoryRepository.findByName("Laptop"));
        assertThat(foundItem).isPresent();
    }
}