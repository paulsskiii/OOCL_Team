package com.day15test.testing;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.day15test.testing.model.InventoryItem;
import com.day15test.testing.repository.InventoryRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InventoryRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test
    void testFindInventoryItemByName(){
        InventoryItem item = new InventoryItem(1, "Laptop", 50.00);
        entityManager.persistAndFlush(item);

        Optional<InventoryItem> foundItem = inventoryRepository.findByName("Laptop");

        assertThat(foundItem).isPresent();
    }
}
