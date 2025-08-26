package com.example.excer2.repository;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.excer2.model.Container;

@DataJpaTest
public class ContainerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ContainerRepository containerRepository;

    @Test
    void given_container_number_when_find_by_container_number_then_should_return_containers() {

        entityManager.persist(new Container("OOOCL1233","Manila","Mindanao",150000.22));
        Optional <List <Container>> givenContainer = containerRepository.findByContainerNumber("OOOCL1233");
        assertThat(givenContainer).isPresent();
    }

    @Test
    void given_no_container_number_when_find_by_container_number_then_should_return_no_containers() {
        Optional <List <Container>> givenContainer = containerRepository.findByContainerNumber("OOOCL1233");
        assertThat(givenContainer).isPresent();
    }

}
