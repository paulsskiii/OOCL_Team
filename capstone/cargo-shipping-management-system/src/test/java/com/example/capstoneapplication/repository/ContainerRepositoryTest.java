package com.example.capstoneapplication.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import com.example.capstoneapplication.model.Container;
import com.example.capstoneapplication.model.Port;
import com.example.capstoneapplication.repository.ContainerRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ContainerRepositoryTest {
    @Autowired
    ContainerRepository containerRepo;

    // @Autowired
    // pri

    private List<Container> expectedContainers;


    @BeforeEach
    void setup () {
        expectedContainers = new ArrayList<Container> ();
        expectedContainers.add (new Container ("OOLU164854", "PHAEL", "PHAGO", "ED", 2353.54, "2025-08-28 13:43:00", null, 1L));
        expectedContainers.add (new Container ("TEMU465185", "PHARA", "PHAEL", "EA", 2353.54, "2025-08-25 11:42:05", "2025-08-30 16:30:00", 1L));
        expectedContainers.add (new Container ("TLLU637854", "PHEUQ", "PHAGT", "PD", 2353.54, null, null, 2L));
        expectedContainers.add (new Container ("TLLU637854",2L));
    }

    @Test
    @Transactional
    void test_add_valid_container_all_filled () {
        Container createdContainer = containerRepo.save (expectedContainers.get (0));

        assertEquals (1, containerRepo.findAll ().size ());

        assertEquals (expectedContainers.get (0), createdContainer);
    }

    @Test
    @Transactional
    void test_add_valid_container_minimum_filled () {
        Container createdContainer = containerRepo.save (expectedContainers.get (3));
        assertEquals (1, containerRepo.findAll ().size ());

        assertEquals (expectedContainers.get (3), createdContainer);
    }

    @Test
    @Transactional
    void test_add_valid_container_all_filled_some_null () {
        Container createdContainer = containerRepo.save (expectedContainers.get (2));
        assertEquals (1, containerRepo.findAll ().size ());

        assertEquals (expectedContainers.get (2), createdContainer);
    }

    @Test
    @Transactional
    void test_add_container_exceeding_255_chars () {
        String longName = "KAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAHDSFLKJASHFDLKJASDHFLKAJSDHFLAKJFHAIUSFHALSUFHALWEFJHASLKDJFHASDLKJFHASDLKJFHASDLKJFHASDLKJFHALKSDFKAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAH";

        assertThrows(DataIntegrityViolationException.class , () -> {
            containerRepo.saveAndFlush (new Container (longName, 1L));
        });
    }
    
}
