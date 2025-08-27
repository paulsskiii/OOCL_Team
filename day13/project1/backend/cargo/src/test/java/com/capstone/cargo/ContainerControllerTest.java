package com.capstone.cargo;

import com.capstone.cargo.controller.ContainerController;
import com.capstone.cargo.model.Container;
import com.capstone.cargo.service.ContainerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContainerController.class)
public class ContainerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ContainerService containerService;

    @Autowired
    private ObjectMapper objectMapper;

    private final Container container = new Container(1L, "Dry", "Ace Hardware", "MNL", "Singapore");

    @Test
    public void testCreateContainer() throws Exception {
        when(containerService.createContainer(any(Container.class))).thenReturn(container);

        mockMvc.perform(post("/api/containers/create").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(container))).andExpect(status().isCreated());

        verify(containerService, times(1)).createContainer(any(Container.class));
    }

    @Test
    public void testGetContainers() throws Exception {
        List<Container> containerList = new ArrayList<>();
        containerList.add(container);
        containerList.add(new Container(2L, "Dry", "Ace Hardware", "MNL", "Singapore"));
        when(containerService.getAll()).thenReturn(containerList);

        mockMvc.perform(get("/api/containers")).andExpect(status().isOk()).andExpect(jsonPath("$[0].owner").value("Ace Hardware"));

        verify(containerService, times(1)).getAll();
    }

    @Test
    public void testDeleteContainer() throws Exception {
        when(containerService.deleteContainer(1L)).thenReturn(true);

        mockMvc.perform(delete("/api/containers/1")).andExpect(status().isOk());

        verify(containerService, times(1)).deleteContainer(1L);
    }
}
