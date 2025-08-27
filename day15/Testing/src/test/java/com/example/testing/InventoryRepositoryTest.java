// // --- InventoryRepositoryTest.java (@DataJpaTest) ---
 // @DataJpaTest

 import com.example.testing.InventoryItem;
 import org.junit.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

 import java.util.Optional;

 import static org.assertj.core.api.Assertions.assertThat;


public class InventoryRepositoryTest {
      @Autowired
      private TestEntityManager entityManager;
      @Autowired private InventoryRepository inventoryRepository;
     @Test
     void testFindInventoryItemByName() {
          entityManager.persist(new InventoryItem("Laptop", 50));
          Optional<InventoryItem> foundItem = inventoryRepository.findByName("Laptop");
          assertThat(foundItem).isPresent();
     }
 }