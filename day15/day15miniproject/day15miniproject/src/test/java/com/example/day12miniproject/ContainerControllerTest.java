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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.day12miniproject.controller.ContainerController;
import com.example.day12miniproject.model.Container;
import com.example.day12miniproject.service.ContainerService;

@WebMvcTest(controllers = ContainerController.class)
@Import(ContainerController.class)
public class ContainerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private ContainerService containerService;

    @Test
    void test_given_user_added_new_container_when_created_then_should_return_added_container() throws Exception {
        when(containerService.addContainers(any(Container.class))).thenReturn(new Container(1L, "OOCL_123", 92399.99, "Ph", "Tokyo"));
        String orderJson = "{\"id\":1,\"containerName\":\"OOCL_123\",\"weight\":92399.99,\"origin\":\"Ph\",\"destination\":\"Tokyo\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(orderJson))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.containerName").value("OOCL_123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weight").value(92399.99))
                .andExpect(MockMvcResultMatchers.jsonPath("$.origin").value("Ph"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.destination").value("Tokyo"));
    }

    @Test
    void test_given_an_existing_container_when_deleted_then_should_return_empty_container() throws Exception {
        Container container = new Container(1L, "OOCL_123", 92399.99, "Ph", "Tokyo");
        containerService.deleteContainer(container.getId());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/contaier/{id}", 1))
                .andExpect(status().isNotFound());
    }
}
