package com.example.testexcercise.repository;

// --- InventoryRepositoryTest.java (@DataJpaTest) ---
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import com.example.testexercise.TestExerciseApplication;
import com.example.testexercise.model.InventoryItem;
import com.example.testexercise.repository.InventoryRepository;

// --- InventoryRepositoryTest.java (@DataJpaTest) ---
@DataJpaTest
@ContextConfiguration(classes = TestExerciseApplication.class)
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