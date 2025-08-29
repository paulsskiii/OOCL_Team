package com.example.capstoneapplication;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.capstoneapplication.controller.ContainerController;
import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.service.ContainerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ContainerController.class)
public class ContainerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ContainerService containerService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Container> existingContainers;

    @BeforeEach
    void setUp() {
        existingContainers = new ArrayList<>();
        existingContainers.add(new Container(1L, "OOLU184539", "MNL", "JKT", "IT", 52.34, "2020-12-12 00:00:00", "2023-12-12 00:00:00", 2L));
        existingContainers.add(new Container(2L, "TEMU135481", "SNG", "VAN", "AR", 100.20, "2025-08-28 00:00:00", "2025-09-12 00:00:00", 1L));
    }

    @Test
    void test_add_container() throws Exception {
        Container newContainer = new Container(3L, "TEMU123481", "SNG", "VAN", "AR", 100.20, "2025-08-28 00:00:00", "2025-09-12 00:00:00", 1L);

        when(containerService.addContainer(any(Container.class))).thenReturn(newContainer);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/container")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newContainer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(9))
                .andExpect(jsonPath("$.id").value(newContainer.getId()))
                .andExpect(jsonPath("$.name").value(newContainer.getName()))
                .andExpect(jsonPath("$.origin").value(newContainer.getOrigin()))
                .andExpect(jsonPath("$.destination").value(newContainer.getDestination()))
                .andExpect(jsonPath("$.status").value(newContainer.getStatus()))
                .andExpect(jsonPath("$.weight").value(newContainer.getWeight()))
                .andExpect(jsonPath("$.departureDate").value(newContainer.getDepartureDate()))
                .andExpect(jsonPath("$.arrivalDate").value(newContainer.getArrivalDate()))
                .andExpect(jsonPath("$.bookedBy").value(newContainer.getBookedBy()));
    }

    @Test
    void test_get_all_container() throws Exception {
        when(containerService.getAllContainer()).thenReturn(existingContainers);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/container"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2)) // checks array size
                
                 // First container checks
                .andExpect(jsonPath("$[0].id").value(existingContainers.get(0).getId()))
                .andExpect(jsonPath("$[0].name").value(existingContainers.get(0).getName()))
                .andExpect(jsonPath("$[0].origin").value(existingContainers.get(0).getOrigin()))
                .andExpect(jsonPath("$[0].destination").value(existingContainers.get(0).getDestination()))
                .andExpect(jsonPath("$[0].status").value(existingContainers.get(0).getStatus()))
                .andExpect(jsonPath("$[0].weight").value(existingContainers.get(0).getWeight()))
                .andExpect(jsonPath("$[0].departureDate").value(existingContainers.get(0).getDepartureDate()))
                .andExpect(jsonPath("$[0].arrivalDate").value(existingContainers.get(0).getArrivalDate()))
                .andExpect(jsonPath("$[0].bookedBy").value(existingContainers.get(0).getBookedBy()))

                // Second container checks
                .andExpect(jsonPath("$[1].id").value(existingContainers.get(1).getId()))
                .andExpect(jsonPath("$[1].name").value(existingContainers.get(1).getName()))
                .andExpect(jsonPath("$[1].origin").value(existingContainers.get(1).getOrigin()))
                .andExpect(jsonPath("$[1].destination").value(existingContainers.get(1).getDestination()))
                .andExpect(jsonPath("$[1].status").value(existingContainers.get(1).getStatus()))
                .andExpect(jsonPath("$[1].weight").value(existingContainers.get(1).getWeight()))
                .andExpect(jsonPath("$[1].departureDate").value(existingContainers.get(1).getDepartureDate()))
                .andExpect(jsonPath("$[1].arrivalDate").value(existingContainers.get(1).getArrivalDate()))
                .andExpect(jsonPath("$[1].bookedBy").value(existingContainers.get(1).getBookedBy()));
    }

    @Test
    void test_get_container_by_id() throws Exception {
        Container foundContainer = existingContainers.get(0);

        when(containerService.getContainerById(1L)).thenReturn(Optional.of(foundContainer));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/container/{id}", foundContainer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(9))
                .andExpect(jsonPath("$.id").value(foundContainer.getId()))
                .andExpect(jsonPath("$.name").value(foundContainer.getName()))
                .andExpect(jsonPath("$.origin").value(foundContainer.getOrigin()))
                .andExpect(jsonPath("$.destination").value(foundContainer.getDestination()))
                .andExpect(jsonPath("$.status").value(foundContainer.getStatus()))
                .andExpect(jsonPath("$.weight").value(foundContainer.getWeight()))
                .andExpect(jsonPath("$.departureDate").value(foundContainer.getDepartureDate()))
                .andExpect(jsonPath("$.arrivalDate").value(foundContainer.getArrivalDate()))
                .andExpect(jsonPath("$.bookedBy").value(foundContainer.getBookedBy()));

    }

    @Test
    void test_delete_container_by_id() throws Exception {
        Container containerToDelete = existingContainers.get(1);

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/api/container/{id}", containerToDelete.getId()))
                .andExpect(status().isOk());

        verify(containerService, times(1)).deleteContainer(containerToDelete.getId());
    }

    @Test
    void test_update_container_by_id() throws Exception {
        Container containerToUpdate = existingContainers.get(0);

        Container updatedContainer = new Container(
                containerToUpdate.getId(),
                "UPDATED_NAME",
                "UPDATED_ORIGIN",
                "UPDATED_DESTINATION",
                "UPDATED_STATUS",
                200.50,
                "2025-09-01 00:00:00",
                "2025-09-15 00:00:00",
                5L
        );

        when(containerService.updateContainer(any(Container.class), eq(containerToUpdate.getId())))
                .thenReturn(updatedContainer);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/container/{id}", containerToUpdate.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedContainer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(updatedContainer.getId()))
                .andExpect(jsonPath("$.name").value(updatedContainer.getName()))
                .andExpect(jsonPath("$.origin").value(updatedContainer.getOrigin()))
                .andExpect(jsonPath("$.destination").value(updatedContainer.getDestination()))
                .andExpect(jsonPath("$.status").value(updatedContainer.getStatus()))
                .andExpect(jsonPath("$.weight").value(updatedContainer.getWeight()))
                .andExpect(jsonPath("$.departureDate").value(updatedContainer.getDepartureDate()))
                .andExpect(jsonPath("$.arrivalDate").value(updatedContainer.getArrivalDate()));

        verify(containerService, times(1))
                .updateContainer(any(Container.class), eq(containerToUpdate.getId()));
    }


}
