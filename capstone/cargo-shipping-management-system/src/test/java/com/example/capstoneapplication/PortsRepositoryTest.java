package com.example.capstoneapplication;

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

import com.example.capstoneapplication.model.Port;
import com.example.capstoneapplication.repository.PortsRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class PortsRepositoryTest {
    @Autowired
    PortsRepository PortRepo;

    private List<Port> expectedPort;


    @BeforeEach
    void setup () {
        expectedPort = new ArrayList<Port> ();
        expectedPort.add (new Port ("PD", "Pending", 1));
        expectedPort.add (new Port ("AR", "Arrived", 1));
    }

    @Test
    @Transactional
    void test_add_valid_Port () {
        Port createdPort = PortRepo.save (expectedPort.get (0));

        assertEquals (1, PortRepo.findAll ().size ());

        assertEquals (expectedPort.get (0), createdPort);
    }

    @Test
    @Transactional
    void test_add_existing_Port () {
        PortRepo.save (expectedPort.get (0));
        PortRepo.save (expectedPort.get (0));

        assertEquals(1, PortRepo.findAll ().size ());
    }
    
    @Test
    @Transactional
    void test_add_invalid_Port_id_exceeding_5_chars () {
        assertThrows(DataIntegrityViolationException.class, () -> {
            PortRepo.save (new Port ("MNLADHW", "Manilalala", 1));
            PortRepo.findAll ();
        });
    }

    @Test
    @Transactional
    void test_add_invalid_Port_name_exceeding_255_chars () {
        String longName = "KAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAHDSFLKJASHFDLKJASDHFLKAJSDHFLAKJFHAIUSFHALSUFHALWEFJHASLKDJFHASDLKJFHASDLKJFHASDLKJFHASDLKJFHALKSDFKAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAH";
        assertThrows(DataIntegrityViolationException.class, () -> {
            PortRepo.save (new Port ("MNLHH", longName, 1));
            PortRepo.findAll ();
        });
    }
}
