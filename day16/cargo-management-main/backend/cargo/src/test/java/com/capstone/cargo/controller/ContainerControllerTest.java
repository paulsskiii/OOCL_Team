package com.capstone.cargo.controller;

import com.capstone.cargo.model.Container;
import com.capstone.cargo.repository.ContainerRepository;
import com.capstone.cargo.service.ContainerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@DataJpaTest
class ContainerControllerTest {

    @Mock
    private Container e;

//    @Autowired
//    private MockMvc mockMvc;

    @Mock
    private ContainerRepository containerRepository;

    @InjectMocks
    private ContainerController containerController;

    @InjectMocks
    private ContainerService containerService;

    @BeforeEach
    void setUp() {
        e = new Container();
        e.setId(1L);
        e.setContainerType("Container");
        e.setOwner("Owner");
        e.setOrigin("Origin");
        e.setDestination("Destination");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldCreateNewContainer() {
//        when(containerService.addContainer(container)).thenReturn(1,"OOCL","Alexis","PH","Korea");
//
//        this.mockMvc.perform(get("/add")).andDo(print()).andExpect(status().isCreated())
//                .andExpect(content().string(containsString(1,"OOCL","Alexis","PH","Korea")));
        System.out.println("E: " + e);
        Container newContainer = new Container(1L,"OOCL","Alexis","PH","Korea");
        System.out.println("Start of new" + newContainer);

        containerService.addContainer(newContainer);
        System.out.println(newContainer);
        System.out.println("NewContainer: " + newContainer);

        verify(containerRepository, times(1)).save(e);
    }
}