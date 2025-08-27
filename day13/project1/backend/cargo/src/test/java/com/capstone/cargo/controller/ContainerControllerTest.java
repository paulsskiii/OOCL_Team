package com.capstone.cargo.controller;

import com.capstone.cargo.model.Container;
import com.capstone.cargo.repository.ContainerRepository;
import com.capstone.cargo.service.ContainerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

// Only test the repository and not the controller itself
@WebMvcTest(ContainerController.class)
class ContainerControllerTest {

    @MockitoBean
    private ContainerRepository containerRepository;

    @MockitoBean
    private ContainerService containerService;

    @Test
    public void GivenOnLoad_WhenGetAllTriggered_ThenReturnAllContainers () {
        when(containerRepository.findAll()).thenReturn(List.of(new Container(1L,"Dangerous","OOCL", "Cebu", "Hong Kong")));

        List<Container> containers = containerRepository.findAll();

        assertNotNull(containers);
        verify(containerRepository, times(1)).findAll();
    }

}