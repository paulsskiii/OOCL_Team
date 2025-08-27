package com.capstone.cargo;

import com.capstone.cargo.model.Container;
import com.capstone.cargo.repository.ContainerRepository;
import com.capstone.cargo.service.ContainerService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ContainerServiceTest {

    @Mock
    private ContainerRepository containerRepository;

    @InjectMocks
    private ContainerService containerService;

    private Container container;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        container = new Container(1L, "Dry", "Maersk", "MNL", "Singapore");
    }

    @Test
    public void testCreateContainer() {
        when(containerRepository.save(container)).thenReturn(container);
        Container saved = containerService.createContainer(container);

        assertThat(saved.getOwner()).isEqualTo("Maersk");
        verify(containerRepository, times(1)).save(container);
    }

    @Test
    public void testGetContainerById() {
        when(containerRepository.findById(1L)).thenReturn(Optional.ofNullable(container));

        Optional<Container> findId = containerService.getContainerById(1L);

        assertThat(findId).isPresent();
        assertThat(findId.get().getContainerType()).isEqualTo("Dry");
    }

    @Test
    public void testGetAllContainers() {
        when(containerRepository.findAll()).thenReturn(Collections.singletonList(container));

        List<Container> all = containerService.getAll();

        assertThat(all).hasSize(1);
        verify(containerRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteContainer() {
        when(containerRepository.existsById(1L)).thenReturn(true);
        doNothing().when(containerRepository).deleteById(1L);

        containerService.deleteContainer(1L);

        verify(containerRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateContainer() {
        Container updatedData = new Container(null, "PCT", "OOCL", "MNL", "HKG");
        when(containerRepository.findById(1L)).thenReturn(Optional.of(container));
        when(containerRepository.save(any(Container.class))).thenReturn(updatedData);

        Container updated = containerService.updateContainer(1L, updatedData);

        assertThat(updated.getContainerType()).isEqualTo("PCT");
        assertThat(updated.getOwner()).isEqualTo("OOCL");
    }

}
