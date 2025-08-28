package com.group1.capstone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.group1.capstone.CapstoneApplication;
import com.group1.capstone.exceptions.SameOriginDestinationException;
import com.group1.capstone.model.Container;
import com.group1.capstone.service.ContainerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CapstoneApplication.class)
@SpringBootTest(classes = ContainerController.class)
public class ContainerControllerTest {
    private ContainerService containerService;
    private ContainerController containerController;

    @BeforeEach
    void setUp() {
        containerService = mock(ContainerService.class);
        containerController = new ContainerController(containerService);
    }

    @Test
    void testGetAllContainers() {
        Container c1 = new Container("C001", "Manila", "Cebu", 50.5);
        Container c2 = new Container("C002", "Batangas", "Pasay", 50.5);

        when(containerService.getAllContainers()).thenReturn(Arrays.asList(c1, c2));
        ResponseEntity<List<Container>> response = containerController.getAllContainers();
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testGetContainerById_found() {
        Container c1 = new Container("C001", "Manila", "Cebu", 50.5);

        when(containerService.getAllContainers()).thenReturn(List.of(c1));
        ResponseEntity<Container> response = containerController.getContainerById("C001");
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testGetContainerById_notFound() {
        Container c2 = new Container("C002", "Manila", "Cebu", 50.5);

        when(containerService.getAllContainers()).thenReturn(List.of(c2));
        ResponseEntity<Container> response = containerController.getContainerById("C002");
        assertNotEquals(404, response.getStatusCode().value());
    }

    @Test
    void testAddContainer() throws NullPointerException, SameOriginDestinationException {
        Container c3 = new Container("C003", "Manila", "Cebu", 50.5);

        when(containerService.addContainer(any(Container.class))).thenReturn(c3);
        ResponseEntity<Container> response = containerController.addContainer(c3);
        assertEquals(201, response.getStatusCode().value());
    }

    @Test
    void testUpdateContainer() {
        Container c3 = new Container("C003", "Quezon", "Cebu", 50.5);

        when(containerService.updateContainer(any(Container.class))).thenReturn(c3);
        ResponseEntity<Container> response = containerController.updateContainer("C003", c3);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testDeleteContainer() {
        Container c3 = new Container("C003", "Quezon", "Cebu", 50.5);

        doNothing().when(containerService).deleteContainer(c3);
        containerController.deleteContainer("C005", c3);
        verify(containerService, times(1)).deleteContainer(c3);
    }

     @Test
    void testUpdateContainerWithAllData() {
        Container c3 = new Container("C003", "Quezon", "Cebu", 50.5);

        when(containerService.updateContainer(any(Container.class))).thenReturn(c3);
        ResponseEntity<Container> response = containerController.updateContainer("C003", c3);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testUpdateContainerWithoutOrigin() {
        Container c3 = new Container("C023", "", "Iloilo", 50.5);

        when(containerService.updateContainer(any(Container.class))).thenReturn(c3);
        ResponseEntity<Container> response = containerController.updateContainer("C003", c3);
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void testUpdateContainerWithoutDestination() {
        Container c3 = new Container("C023", "Tondo", "", 50.5);

        when(containerService.updateContainer(any(Container.class))).thenReturn(c3);
        ResponseEntity<Container> response = containerController.updateContainer("C003", c3);
        assertEquals(200, response.getStatusCode().value());
    }
}
