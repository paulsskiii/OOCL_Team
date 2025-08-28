package com.group1.capstone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import com.group1.capstone.CapstoneApplication;
import com.group1.capstone.exception.SameOriginDestinationException;
import com.group1.capstone.model.Container;
import com.group1.capstone.repository.ContainerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.group1.capstone.ContainerProducer;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = ContainerService.class)
@ContextConfiguration(classes = CapstoneApplication.class)
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
    void testAddContainer() throws NullPointerException, SameOriginDestinationException {
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
    void testDeleteContainer() throws NullPointerException, SameOriginDestinationException {

        Container savedContainer = new Container("OOLU12345", "Manila", "Singapore", 1200.40);

        when(containerRepository.save(any())).thenReturn(savedContainer);
        when(containerRepository.findByContainerNumber(savedContainer.getContainerNumber()))
            .thenReturn(Optional.empty()); 

        Container toDeleteContainer = containerService.addContainer(savedContainer);
        containerService.deleteContainer(toDeleteContainer);


        assertThat(containerRepository.findByContainerNumber(savedContainer.getContainerNumber()))
            .isNotPresent();
    }

     // Group Activity
    @Test
    void testAddContainerWithNullContainerNumber() {
        Container container = new Container(null, "Manila", "Cebu", 50.5);
        when(containerRepository.save(any(Container.class))).thenReturn(container);
            
        Exception exception = assertThrows(NullPointerException.class, () -> {
            containerService.addContainer(container);
        });

        String expectedMessage = "Container Number is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Passed");
    }

    @Test
    void testAddContainerWithNullOrigin() {
        Container container = new Container("C003", null, "Cebu", 50.5);
        when(containerRepository.save(any(Container.class))).thenReturn(container);
            
        Exception exception = assertThrows(NullPointerException.class, () -> {
            containerService.addContainer(container);
        });

        String expectedMessage = "Origin is null";
        String actualMessage = exception.getMessage();
        System.out.println(actualMessage);
        System.out.println(expectedMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAddContainerWithNullDestination() {
        Container container = new Container("C003", "Manila", null, 50.5);
        when(containerRepository.save(any(Container.class))).thenReturn(container);
            
        Exception exception = assertThrows(NullPointerException.class, () -> {
            containerService.addContainer(container);
        });

        String expectedMessage = "Destination is null";
        String actualMessage = exception.getMessage();
        System.out.println("MESSAGE: " + actualMessage);
        System.out.println(expectedMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAddContainerWithSameOriginAndDestination() {
        Container container = new Container("C003", "Manila", "Manila", 50.5);        
        when(containerRepository.save(any(Container.class))).thenReturn(container);
            
        Exception exception = assertThrows(Exception.class, () -> {
            containerService.addContainer(container);
        });
        String expectedMessage = "Origin and Destination should not be the same";
        String actualMessage = exception.getMessage();
        System.out.println("MESSAGE: " + actualMessage);
        System.out.println(expectedMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // @Test
    // void testAddContainerWithExistingContainerNumber() throws NullPointerException, SameOriginDestinationException{
    //     Container existingContainer = new Container("C003", "Manila", "Quezon", 50.5);        
    //     Container newContainer = new Container("C003", "Cebu", "Manila", 50.5);                

    //     containerService.addContainer(existingContainer);
    //     Exception exception = assertThrows(Exception.class, () -> {
    //         containerService.addContainer(newContainer);
    //     });

    //     String expectedMessage = "Container Number already existing";
    //     String actualMessage = exception.getMessage();
    //     System.out.println("MESSAGE: " + actualMessage);
    //     System.out.println(expectedMessage);
    //     assertTrue(actualMessage.contains(expectedMessage));
    // }

       @Test
    void testSearchByValidContainerNumber () {
        Optional<List<Container>> containers = Optional.of(
            new ArrayList<>(Arrays.asList(
                new Container("OOLU12345", "Manila", "Singapore", 1200.40)
            ))
        );

        when(containerRepository.findByContainerNumber(anyString())).thenReturn(containers);

        assertEquals(containers, containerService.getContainerById("OOLU12345"));
    }

    @Test
    void testSearchByInvalidContainerNumber () {
        Container savedContainer = new Container("OOLU12345", "Manila", "Singapore", 1200.40);

        when(containerRepository.save(any())).thenReturn(savedContainer);

        assertThat(containerRepository.findByContainerNumber("OOLU11111"))
            .isNotPresent();
    }

    @Test
    void testFilterByOrigin () {

        List<Container> allContainers = 
            new ArrayList<>(Arrays.asList( 
                new Container("OOLU12345", "Manila", "Singapore", 1200.40),
                new Container("OOLU54321", "Manila", "New York", 603.00),
                new Container("OOLU09876", "India", "Germany", 3899.99)

              ));

        Optional<List<Container>> filteredContainers = Optional.of(
            new ArrayList<>(Arrays.asList(
                new Container("OOLU12345", "Manila", "Singapore", 1200.40),
                new Container("OOLU54321", "Manila", "New York", 603.00)
              ))
        );
    

        when(containerRepository.findByOrigin(anyString())).thenReturn(filteredContainers);
        when(containerRepository.findAll()).thenReturn(allContainers);

        assertNotEquals(containerService.getAllContainers(), containerService.getContainerByOrigin("Manila"));
    }

    @Test
    void testFilterByDestination () {

        List<Container> allContainers = 
            new ArrayList<>(Arrays.asList( 
                new Container("OOLU12345", "Tokyo", "Singapore", 1200.40),
                new Container("OOLU54321", "Manila", "Germany", 603.00),
                new Container("OOLU09876", "India", "Germany", 3899.99)

              ));

        Optional<List<Container>> filteredContainers = Optional.of(
            new ArrayList<>(Arrays.asList(
                new Container("OOLU54321", "Manila", "Germany", 603.00),
                new Container("OOLU09876", "India", "Germany", 3899.99)
              ))
        );
    
        when(containerRepository.findByDestination(anyString())).thenReturn(filteredContainers);
        when(containerRepository.findAll()).thenReturn(allContainers);

        assertNotEquals(containerService.getAllContainers(), containerService.getContainerByDestination("Germany"));
    }

    @Test
    void testUpdateWithNullContainerNumber(){
        Container container = dummyContainerDetails();

        when(containerRepository.save(any())).thenReturn(container);

        Exception exception = assertThrows(Exception.class, () -> {
            containerService.updateContainer(null);
        });

        assertEquals("Container must have value", exception.getMessage());
    }

    @Test
    void testUpdateContainerWithoutOrigin() {
        Container container = new Container("OOLU12345", "", "Singapore", 1200.40);;

        when(containerRepository.save(any())).thenReturn(container);
        
        assertEquals(container, dummyContainerDetailsWithoutOrigin());
    }

    @Test
    void testUpdateContainerWithoutDestination() {
        Container container = new Container("OOLU12345", "Manila", "", 1200.40);

        when(containerRepository.save(any())).thenReturn(container);
        
        assertEquals(container, dummyContainerDetailsWithoutDestination());
    }

    private Container dummyContainerDetails(){
        return new Container("OOLU12345", "Manila", "Singapore", 1200.40);
    }

    private Container dummyContainerDetailsWithoutDestination(){
        Container contWithoutDest = dummyContainerDetails();
        contWithoutDest.setDestination("");
        return contWithoutDest;
    }

    private Container dummyContainerDetailsWithoutOrigin(){
        Container contWithoutDest = dummyContainerDetails();
        contWithoutDest.setOrigin("");
        return contWithoutDest;
    }

}
