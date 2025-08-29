package com.example.capstoneapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.repository.ContainerRepository;
import com.example.capstoneapplication.service.ContainerService;

@ExtendWith(MockitoExtension.class)
public class ContainerServiceTest {

    @Mock
    private ContainerRepository containerRepository;

    @InjectMocks
    private ContainerService containerService;

    private List<Container> expectedContainers;

    private final Long nonExistingID = 9999L;

    @BeforeEach
    void setup() {
        expectedContainers = new ArrayList<>();
        expectedContainers.add(new Container(1L, "OOLU184539", "MNL", "JKT", "IT", 52.34, "2020-12-12 00:00:00", "2023-12-12 00:00:00", 2L));
        expectedContainers.add(new Container(2L, "TEMU135481", "SNG", "VAN", "AR", 100.20, "2025-08-28 00:00:00", "2025-09-12 00:00:00", 1L));
    }

    // Test to add container with complete and valid fields
    // expected: success, created
    @Test
    void test_given_user_added_new_container_with_complete_details_when_created_then_return_added_container() {

        Container newContainer = new Container(3L, "TEMU123481", "SNG", "VAN", "AR", 100.20, "2025-08-28 00:00:00", "2025-09-12 00:00:00", 1L);
        when(containerRepository.findByName(newContainer.getName())).thenReturn(Optional.empty());
        when(containerRepository.save(newContainer)).thenReturn(newContainer);

        Container savedContainer = containerService.addContainer(newContainer);
        assertNotNull(savedContainer);

    }

    // Test to add container with duplicate name
    // expected: error
    @Test
    void test_given_user_adds_new_container_with_duplicate_name_when_created_then_return_exception() {

        Container duplicateContainer = expectedContainers.get(0);
        when(containerRepository.findByName(duplicateContainer.getName())).thenReturn(Optional.of(expectedContainers.get(0)));

        assertThatThrownBy(() -> containerService.addContainer(duplicateContainer))
                .isInstanceOf(ResponseStatusException.class);

        verify(containerRepository, times(1)).findByName(duplicateContainer.getName());
        verify(containerRepository, never()).save(duplicateContainer);

    }

    // Test to get all containers
    // expected: success, return populated list
    @Test
    void test_given_list_of_containers_when_retrieved_then_return_list_of_containers() {

        when(containerRepository.findAll()).thenReturn(expectedContainers);
        List<Container> actualContainers = containerService.getAllContainer();

        assertNotNull(actualContainers);
        assertEquals(actualContainers, expectedContainers);

        verify(containerRepository, times(1)).findAll();

    }

    // Test to get single container based on id (container exists)
    // expected: success, return 1 container with matching id
    @Test
    void test_given_existing_container_when_retrieved_by_id_then_return_container() {

        when(containerRepository.findById(1L)).thenReturn(Optional.of(expectedContainers.get(0)));

        Optional<Container> actualContainer = containerService.getContainerById(1L);

        assertNotNull(actualContainer.get());
        assertEquals(expectedContainers.get(0), actualContainer.get());

        verify(containerRepository, times(1)).findById(1L);

    }

    // Test to get all containers
    // expected: success, return empty list
    @Test
    void test_given_no_existing_containers_when_retrieved_then_return_empty_list() {

        when(containerRepository.findAll()).thenReturn(new ArrayList<Container>());
        List<Container> actualContainers = containerService.getAllContainer();

        assertTrue(actualContainers.isEmpty());
        assertEquals(0, actualContainers.size());

        verify(containerRepository, times(1)).findAll();

    }

    // Test to get single container based on id (container does not exist)
    // expected: success, return 0 containers
    @Test
    void test_given_no_existing_container_when_retrieved_by_id_then_return_empty_container() {

        when(containerRepository.findById(nonExistingID)).thenReturn(Optional.empty());
        Optional<Container> container = containerService.getContainerById(nonExistingID);

        assertTrue(container.isEmpty());

        verify(containerRepository, times(1)).findById(nonExistingID);

    }

    @Test
    void test_given_existing_container_when_updated_return_updated_container(){

        Container updatedContainer = expectedContainers.get(0);
        when(containerRepository.findById(updatedContainer.getId())).thenReturn(Optional.of(updatedContainer));
        updatedContainer.setStatus("AR");
        when(containerRepository.save(updatedContainer)).thenReturn(updatedContainer);

        containerService.updateContainer(updatedContainer, updatedContainer.getId());

        assertEquals(updatedContainer.getStatus(), expectedContainers.get(0).getStatus());
        verify(containerRepository, times(1)).save(updatedContainer);

    }

    @Test
    void test_given_id_is_not_existing_when_updated_then_return_exception(){

        Container newContainer = new Container(3L, "TEMU123481", "SNG", "VAN", "AR", 100.20, "2025-08-28 00:00:00", "2025-09-12 00:00:00", 1L);
        when(containerRepository.findById(newContainer.getId())).thenReturn(Optional.empty());
        newContainer.setStatus("AR");

        assertThatThrownBy(() -> containerService.updateContainer(newContainer, newContainer.getId()))
                .isInstanceOf(ResponseStatusException.class);

        verify(containerRepository, never()).save(newContainer);

    }

    // Test to delete existing container
    // expected: success, 1 container with matching id deleted
    @Test
    void test_given_existing_container_when_deleted_then_remove_record() {

        when(containerRepository.existsById(2L)).thenReturn(true);

        containerService.deleteContainer(2L);

        verify(containerRepository, times(1)).deleteById(2L);

    }

    // Test to delete non existing container (e.g., ID not in system)
    // expected: error, no containers deleted
    @Test
    void test_given_id_is_not_existing_when_deleted_by_id_then_return_exception() {

        when(containerRepository.existsById(nonExistingID)).thenReturn(false);

        assertThatThrownBy(() -> containerService.deleteContainer(nonExistingID))
                .isInstanceOf(ResponseStatusException.class);

        verify(containerRepository, never()).deleteById(nonExistingID);

    }

}
