package com.example.day12miniproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.day12miniproject.controller.ContainerController;
import com.example.day12miniproject.model.Container;
import com.example.day12miniproject.service.ContainerService;

@WebMvcTest(ContainerController.class)
public class ContainerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContainerService containerService;
    @Autowired
    private ContainerService conS;

    String jsonContent = "{\r\n" + //
            "\"id\": 2,\r\n" + //
            "\"containerName\": \"asdfasdf\",\r\n" + //
            "\"weight\": 234,\r\n" + //
            "\"origin\": \"sdfasdf\",\r\n" + //
            "\"destination\": \"asdfasdf\"\r\n" + //
            "}";

    @BeforeEach
    void createTestContainers() throws Exception {
        when(containerService.addContainers(any(Container.class)))
                .thenReturn(new Container(4L, "OOCU12345678", 55.00, "MLL", "SKZ"));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/container").contentType(MediaType.APPLICATION_JSON)
                .content(jsonContent))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void testAddContainer() throws Exception {
        when(containerService.addContainers(any(Container.class)))
                .thenReturn(new Container(4L, "OOCU12345678", 55.00, "MLL", "SKZ"));
        MvcResult res2 = mockMvc
                .perform(MockMvcRequestBuilders.post("/api/container").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(res2.getResponse().getContentAsString());
    }

    @Test
    void testGetAllContainer() throws Exception {
        ArrayList<Container> conss = new ArrayList<>();

        Container container = new Container(5L, "jsonContent", 100, "jsonContent", "jsonContent");
        Container container2 = new Container(6L, "jsonContent", 100, "jsonContent", "jsonContent");

        conss.add(container);
        conss.add(container2);

        when(containerService.getAllContainer()).thenReturn(conss);

        List<Container> result = containerService.getAllContainer();
        assertEquals(conss, result);
    }

    @Test
    void testGetByIdContainer () throws Exception {
        mockMvc.perform (MockMvcRequestBuilders.get ("/api/container/2"))
            .andExpect (status().isOk());
    }

}
