package com.capstone.cargo.service;

import com.capstone.cargo.model.Container;
import com.capstone.cargo.repository.ContainerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ContainerServiceTest {

    @Mock
    private Container e;

    @Mock
    private ContainerRepository containerRepository;

//    @MockitoBean
    @InjectMocks
    private ContainerService containerService;

    @BeforeEach
    void setUp() {
        System.out.println("Test Start");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test End");
    }

    @Test
    void shouldAddContainer() {

        Container newContainer = new Container(1L,"OOCL","Alexis","PH","Korea");
        Mockito.when(containerRepository.save(newContainer)).thenReturn(newContainer);

        Container createdContainer = containerService.addContainer(newContainer);
        assertEquals(createdContainer,newContainer);
    }

    @Test
    void shouldBeAbleToSaveNulls() {

        Container newContainer = new Container();
        newContainer.setId(1L);
        newContainer.setContainerType(null);
        newContainer.setOwner(null);
        newContainer.setOrigin(null);
        newContainer.setDestination(null);

        Mockito.when(containerRepository.save(newContainer)).thenReturn(newContainer);

        Container createdContainer = containerRepository.save(newContainer);
        assertEquals(createdContainer,newContainer);
    }

    @Test
    void test() {

        Container container = new Container(1L,"OOCL","Alexis","PH","Korea");
    }
}