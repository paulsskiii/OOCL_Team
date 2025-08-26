// --- InventoryRepositoryTest.java (@DataJpaTest) ---
// @DataJpaTest
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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