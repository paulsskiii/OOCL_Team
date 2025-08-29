// package com.example.capstoneapplication;
 
// import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.example.capstoneapplication.model.Container;
// import com.example.capstoneapplication.repository.ContainerRepository;
// import com.example.capstoneapplication.service.ContainerService;

 
// @ExtendWith(MockitoExtension.class)
// public class ContainerServiceTest {
//     @Mock
//     private ContainerRepository containerRepository;

//     @InjectMocks
//     private ContainerService containerService;
 
//     private List<Container> expectedContainers;
//     private List<Container> soloContainers;

//     private final Long nonExistingID = 9999L;
 
//     @BeforeEach
//     void setup() {
//         expectedContainers = new ArrayList<>();
//         expectedContainers.add(new Container(1L, "OOLU184539", 100, "MNL", "JKT"));
//         expectedContainers.add(new Container(6L, "TEMU135481", 500, "SNG", "VAN"));

//         soloContainers = new ArrayList<> ();
//         soloContainers.add (expectedContainers.get (0));
//     }
 
//     // Test to get all containers
//     // expected: success, return populated list
//     @Test
//     void testGetAllContainersPopulated() {
 
//         when(containerRepository.findAll()).thenReturn(expectedContainers);
//         List<Container> actualContainers = containerService.getAllContainer();
 
//         assertNotNull(actualContainers);
//         assertEquals(actualContainers, expectedContainers);
 
//         verify(containerRepository, times(1)).findAll();
//     }
 
//     // Test to get single container based on id (container exists)
//     // expected: success, return 1 container with matching id
//     @Test
//     void testGetExistingContainerById() {
//         // Container container = new Container(1L, "OOLU184539", 100, "MNL", "JKT");
 
//         when(containerRepository.findById(1L)).thenReturn(Optional.of(expectedContainers.get (0)));
 
//         Optional<Container> container2 = containerService.getContainerById(1L);
 
//         assertNotNull(container2.get ());
//         assertEquals(expectedContainers.get (0), container2.get ());
 
//     }
 
//     // Test to add container with complete and valid fields
//     // expected: success, created
//     @Test
//     void testAddValidContainer() {
//         // Mock repository actions
//         when(containerRepository.save (any (Container.class))).thenReturn (expectedContainers.get (0));
//         when(containerRepository.findAll ()).thenReturn (soloContainers);

//         containerService.addContainers (expectedContainers.get (0));
//         List<Container> getAllContainers = containerService.getAllContainer ();

//         assertEquals (1, getAllContainers.size ());
//         assertEquals (soloContainers.get (0), getAllContainers.get (0));
//     }
 
//     // Test to add container with incomplete fields
//     // expected: error, no creation
//     // commented out, as seemingly impossible / not for a unit test
//     // @Test
//     // void testAddIncompleteContainer() {
//     // }
 
//     // Test to add container with invalid fields (e.g., string in weight)
//     // expected: error, no creation
//     // commented out, as seemingly impossible / not for a unit test
//     // @Test
//     // void testAddInvalidContainer() {
//     // }
 
//     // Test to delete existing container
//     // expected: success, 1 container with matching id deleted
//     @Test
//     void testDeleteExistingContainer() {
//         when(containerRepository.findAll()).thenReturn(soloContainers);
//         doNothing ().when (containerRepository).deleteById (6L);

//         containerService.deleteContainer(6L);
//         List<Container> getAllContainer = containerService.getAllContainer ();
 
//         assertEquals (1, getAllContainer.size ());
//         assertArrayEquals (soloContainers.toArray(),  getAllContainer.toArray());

//         verify (containerRepository, times (1)).findAll ();
//         verify (containerRepository, times (1)).deleteById(6L);
//     }
 
//     // Test to delete non existing container (e.g., ID not in system)
//     // expected: error, no containers deleted
//     @Test
//     void testDeleteNonExistingContainer() {
//         when(containerRepository.findAll()).thenReturn(expectedContainers);
//         doNothing ().when (containerRepository).deleteById (nonExistingID);

//         containerService.deleteContainer(nonExistingID);
//         List<Container> getAllContainer = containerService.getAllContainer ();
 
//         assertEquals (expectedContainers.size (), getAllContainer.size ());
//         assertArrayEquals (expectedContainers.toArray(),  getAllContainer.toArray());

//         verify (containerRepository, times (1)).findAll ();
//         verify (containerRepository, times (1)).deleteById(nonExistingID);
//     }
 
//     // Test to delete container with invalid identifier (e.g., passed non-id as
//     // param)
//     // expected: error, no containers deleted
//     // commented out, as seemingly impossible / not for a unit test
//     // @Test
//     // void testDeleteInvalidContainer() {
//     // }
 
//     // Test to get all containers
//     // expected: success, return empty list
//     @Test
//     void testGetAllContainersEmpty() {
//         when(containerRepository.findAll()).thenReturn(new ArrayList<Container>());
//         List<Container> actualContainers = containerService.getAllContainer();
 
//         assertNotNull(actualContainers);
//         assertEquals(0, actualContainers.size ());
 
//         verify(containerRepository, times(1)).findAll();
//     }
 
//     // Test to get single container based on id (container does not exist)
//     // expected: success, return 0 containers
//     @Test
//     void testGetNonExistingContainer() {
//         when (containerRepository.findById (nonExistingID)).thenReturn (Optional.empty ());
//         Optional<Container> container = containerService.getContainerById (nonExistingID);

//         assertTrue (container.isEmpty ());

//         verify (containerRepository, times (1)).findById (nonExistingID);
//     }
// }