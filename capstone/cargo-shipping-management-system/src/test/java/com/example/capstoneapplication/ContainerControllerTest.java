package com.example.capstoneapplication;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.capstoneapplication.controller.ContainerController;
import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.service.ContainerService;

@WebMvcTest(ContainerController.class)
public class ContainerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContainerService containerService;

    private final Container container = new Container(1L, "OOLU184539", 100, "MNL", "JKT");

    String jsonContent = "{\r\n" + //
            "\"id\": 2,\r\n" + //
            "\"containerName\": \"asdfasdf\",\r\n" + //
            "\"weight\": 234,\r\n" + //
            "\"origin\": \"sdfasdf\",\r\n" + //
            "\"destination\": \"asdfasdf\"\r\n" + //
            "}";

//     @BeforeEach
//     void createTestContainers() throws Exception {
//         when(containerService.addContainers(any(Container.class)))
//                 .thenReturn(new Container(4L, "OOCU12345678", 55.00, "MLL", "SKZ"));
//         mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(MediaType.APPLICATION_JSON)
//                 .content(jsonContent))
//                 .andExpect(status().isOk())
//                 .andReturn();                
//     }

    @Test
    void testAddContainer() throws Exception {
        when(containerService.addContainer(any(Container.class)))
                .thenReturn(container);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect (jsonPath("$.length()").value (5))
                .andExpect(jsonPath("$.id").value(container.getId ()))
                .andExpect(jsonPath("$.containerName").value(container.getContainerName()))
                .andExpect(jsonPath("$.weight").value(container.getWeight()))
                .andExpect(jsonPath("$.origin").value(container.getOrigin()))
                .andExpect(jsonPath("$.destination").value(container.getDestination()));
    }

    @Test
    void testGetAllContainer() throws Exception {
        List<Container> containers = new ArrayList<>();

        Container container2 = new Container(6L, "TEMU135481", 500, "SNG", "VAN");

        containers.add(container);
        containers.add(container2);

        when(containerService.getAllContainer()).thenReturn(containers);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/container").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect (status().isOk())
                .andExpect (jsonPath("$.length()").value (2))
                .andExpect(jsonPath("$[0].id").value(containers.get (0).getId ()))
                .andExpect(jsonPath("$[0].containerName").value(containers.get (0).getContainerName()))
                .andExpect(jsonPath("$[0].weight").value(containers.get (0).getWeight()))
                .andExpect(jsonPath("$[0].origin").value(containers.get (0).getOrigin()))
                .andExpect(jsonPath("$[0].destination").value(containers.get (0).getDestination()))
                .andExpect(jsonPath("$[1].id").value(containers.get (1).getId ()))
                .andExpect(jsonPath("$[1].containerName").value(containers.get (1).getContainerName()))
                .andExpect(jsonPath("$[1].weight").value(containers.get (1).getWeight()))
                .andExpect(jsonPath("$[1].origin").value(containers.get (1).getOrigin()))
                .andExpect(jsonPath("$[1].destination").value(containers.get (1).getDestination()));
    }

    @Test
    void testGetByIdContainer () throws Exception {        
        when(containerService.getContainerById(1L)).thenReturn(Optional.of(container));
        mockMvc.perform (MockMvcRequestBuilders.get ("/api/container/1"))
            .andExpect (status().isOk())
            .andExpect (jsonPath("$.length()").value (5))
            .andExpect(jsonPath("$.id").value(container.getId ()))
            .andExpect(jsonPath("$.containerName").value(container.getContainerName()))
            .andExpect(jsonPath("$.weight").value(container.getWeight()))
            .andExpect(jsonPath("$.origin").value(container.getOrigin()))
            .andExpect(jsonPath("$.destination").value(container.getDestination()));
    }

}
