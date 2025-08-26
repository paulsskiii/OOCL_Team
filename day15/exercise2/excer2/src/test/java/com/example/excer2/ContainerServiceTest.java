package com.example.excer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.excer2.model.Container;
import com.example.excer2.repository.ContainerRepository;
import com.example.excer2.service.ContainerService;

@SpringBootTest
public class ContainerServiceTest {
    
    @Mock private ContainerRepository containerRepository;
    @InjectMocks private ContainerService containerService;

    @Test
    void testGetAllContainers() {
        List<Container> containers = new ArrayList<>(Arrays.asList(new Container("OOLU12345", "Manila", "Singapore", 1200.40),
            new Container("OOLU54321", "Tokyo", "New York", 603.00),
            new Container("OOLU09876", "India", "Germany", 3899.99)));

        when(containerRepository.findAll()).thenReturn(containers);

        assertEquals(containers, containerService.getAllContainers());
    }
}
