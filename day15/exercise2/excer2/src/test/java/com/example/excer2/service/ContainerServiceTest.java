package com.example.excer2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.excer2.ContainerProducer;
import com.example.excer2.model.Container;
import com.example.excer2.repository.ContainerRepository;

@SpringBootTest
public class ContainerServiceTest {
    
    @Mock private ContainerRepository containerRepository;
    @Mock private ContainerProducer containerProducer;
    @InjectMocks private ContainerService containerService;

    @Test
    void testGetAllContainers() {
        List<Container> containers = new ArrayList<>(Arrays.asList(new Container("OOLU12345", "Manila", "Singapore", 1200.40),
            new Container("OOLU54321", "Tokyo", "New York", 603.00),
            new Container("OOLU09876", "India", "Germany", 3899.99)));

        when(containerRepository.findAll()).thenReturn(containers);

        assertEquals(containers, containerService.getAllContainers());
    }

    @Test
    void testGetContainerById() {
        Optional<List<Container>> containers = Optional.of(
            new ArrayList<>(Arrays.asList(
                new Container("OOLU12345", "Manila", "Singapore", 1200.40)
            ))
        );

        when(containerRepository.findByContainerNumber(anyString())).thenReturn(containers);

        assertEquals(containers, containerService.getContainerById("OOLU12345"));
    }

    @Test
    void testAddContainer() {
        Container container = new Container("OOLU12345", "Manila", "Singapore", 1200.40);

        when(containerRepository.save(any())).thenReturn(container);

        assertEquals(container, containerService.addContainer(container));
    }

    @Test
    void testUpdateContainer() {
        Container container = new Container("OOLU12345", "Manila", "Singapore", 1200.40);

        when(containerRepository.save(any())).thenReturn(container);

        assertEquals(container, containerService.updateContainer(container));
    }

    @Test
    void testDeleteContainer() {

        Container savedContainer = new Container("OOLU12345", "Manila", "Singapore", 1200.40);

        when(containerRepository.save(any())).thenReturn(savedContainer);
        when(containerRepository.findByContainerNumber(savedContainer.getContainerNumber()))
            .thenReturn(Optional.empty()); 

        Container toDeleteContainer = containerService.addContainer(savedContainer);
        containerService.deleteContainer(toDeleteContainer);


        assertThat(containerRepository.findByContainerNumber(savedContainer.getContainerNumber()))
            .isNotPresent();
    }

}
