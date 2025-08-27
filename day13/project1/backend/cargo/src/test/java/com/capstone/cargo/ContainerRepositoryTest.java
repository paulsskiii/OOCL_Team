package com.capstone.cargo;

import com.capstone.cargo.model.Container;
import com.capstone.cargo.repository.ContainerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ContainerRepositoryTest {

    @Autowired
    private ContainerRepository containerRepository;

    @Test
    public void testCreateContainer() {
        Container container = new Container(null, "Dry", "Maersk", "Manila", "Singapore");
        Container saved = containerRepository.save(container);

        Optional<Container> found = containerRepository.findById(saved.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getOwner()).isEqualTo("Maersk");
    }

    @Test
    public void testGetAllContainers() {
        containerRepository.save(new Container(null, "Dry", "Maersk", "Cebu", "Tokyo"));
        containerRepository.save(new Container(null, "RFR", "Ace Hardware", "MNL", "HKG"));

        List<Container> containerList = containerRepository.findAll();

        assertThat(containerList).hasSize(2);
    }

    @Test
    public void testGetContainerByOwner() {
        containerRepository.save(new Container(null, "RFR", "Ace Hardware", "MNL", "HKG"));

        Optional<Container> findOwner = containerRepository.findByOwner("Ace Hardware");

        assertThat(findOwner).isPresent();
        assertThat(findOwner.get().getDestination()).isEqualTo("HKG");
    }

    @Test
    public void testUpdateContainer() {
        Container container = new Container(null, "Dry", "Ace Hardware", "Cebu", "Hong Kong");
        Container saved = containerRepository.save(container);

        saved.setDestination("Busan");
        Container updated = containerRepository.save(saved);

        assertThat(updated.getDestination()).isEqualTo("Busan");
    }

    @Test
    public void testDeleteContainer() {
        Container container = new Container(null, "Dry", "ONE", "Subic", "Kaohsiung");
        Container saved = containerRepository.save(container);

        containerRepository.deleteById(saved.getId());

        Optional<Container> deleted = containerRepository.findById(saved.getId());
        assertThat(deleted).isNotPresent();
    }

}
