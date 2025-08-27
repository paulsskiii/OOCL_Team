package com.example.day12miniproject;


import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.day12miniproject.controller.ContainerController;
import com.example.day12miniproject.model.Container;
import com.example.day12miniproject.service.ContainerService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest(controllers = ContainerController.class)
@Import(ContainerController.class)
public class ContainerControllerTest {
      @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ContainerService containerService;

    @Test
    void test_given_user_added_new_container_when_created_then_should_return_added_container() throws Exception {
        when(containerService.addContainers(any(Container.class))).thenReturn(new Container(1L, "OOCL123", 92399.99, "Ph", "Tokyo"));
        String orderJson = "{\"id\":1,\"containerName\":\"OOCL123\",\"weight\":92399.99,\"origin\":\"Ph\",\"destination\":\"Tokyo\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.containerName").value("OOCL123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weight").value(92399.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.origin").value("Ph"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.destination").value("Tokyo"));
    }

    @Test
    void test_given_an_existing_container_when_deleted_then_should_return_empty_container() throws Exception {
        Container container = new Container(1L, "OOCL_123", 92399.99, "Ph", "Tokyo");
        containerService.deleteContainer(container.getId());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/container/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_given_an_nonexisting_container_when_deleted_then_should_return_error() throws Exception {
        Container container = new Container(1L, "OOCL_123", 92399.99, "Ph", "Tokyo");
        containerService.deleteContainer(container.getId());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/container/{id}", 2))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_given_search_for_nonexistingContainerId_when_retrieved_then_should_return_emptyContainerDetails()
            throws Exception {
        Container container = new Container(1L, "OOCL_123", 92399.99, "Ph", "Tokyo");
        containerService.getContainerById(container.getId());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/container/{id}", 2))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_given_search_for_all_existingContainerId_when_retrieved_then_should_return_all_ContainerDetails()
            throws Exception {
        List<Container> containers = new ArrayList<>();
        containers.add(new Container(1L, "OOCL_123", 92399.99, "Ph", "Tokyo"));
        containers.add(new Container(2L, "OOCL_456", 12345.99, "Taiwan", "Ph"));

        when(containerService.getAllContainer()).thenReturn(containers);
        mockMvc.perform(get("/api/container"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].containerName").value("OOCL_123"))
                .andExpect(jsonPath("$[0].weight").value(92399.99))
                .andExpect(jsonPath("$[0].origin").value("Ph"))
                .andExpect(jsonPath("$[0].destination").value("Tokyo"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].containerName").value("OOCL_456"))
                .andExpect(jsonPath("$[1].weight").value(12345.99))
                .andExpect(jsonPath("$[1].origin").value("Taiwan"))
                .andExpect(jsonPath("$[1].destination").value("Ph"));
    }

    //Test Invalid format for Container name
    @Test
    void test_given_user_added_new_container_with_invalid_format_on_containerName_then_should_return_error() throws Exception {
        when(containerService.addContainers(any(Container.class))).thenReturn(new Container(1L, "@OOCL_123", 92399.99, "Ph", "Tokyo"));
        String orderJson = "{\"id\":1,\"containerName\":\"@OOCL_123\",\"weight\":92399.99,\"origin\":\"Ph\",\"destination\":\"Tokyo\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
                .andExpect(status().is4xxClientError());
    }

    //Test Invalid format for origin
    // @Test
    // void test_given_user_added_new_container_with_invalid_format_on_origin_then_should_return_error() throws Exception {
    //     when(containerService.addContainers(any(Container.class))).thenReturn(new Container(1L, "OOCL123", 92399.99, "@Ph!", "Tokyo"));
    //     String orderJson = "{\"id\":1,\"containerName\":\"OOCL123\",\"weight\":92399.99,\"origin\":\"@Ph!\",\"destination\":\"Tokyo\"}";
    //     mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
    //             .andExpect(status().is4xxClientError());
    // }
}
