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

import com.example.capstoneapplication.model.Status;
import com.example.capstoneapplication.repository.StatusRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class StatusRepositoryTest {
    @Autowired
    StatusRepository statusRepo;

    private List<Status> expectedStatus;


    @BeforeEach
    void setup () {
        expectedStatus = new ArrayList<Status> ();
        expectedStatus.add (new Status ("PD", "Pending"));
        expectedStatus.add (new Status ("AR", "Arrived"));
    }

    @Test
    @Transactional
    void test_add_valid_status () {
        Status createdUserCred = statusRepo.save (expectedStatus.get (0));

        assertEquals (1, statusRepo.findAll ().size ());

        assertEquals (expectedStatus.get (0), createdUserCred);
    }

    @Test
    @Transactional
    void test_add_existing_status () {
        statusRepo.save (expectedStatus.get (0));
        statusRepo.save (expectedStatus.get (0));

        assertEquals(1, statusRepo.findAll ().size ());
    }
    
    @Test
    @Transactional
    void test_add_invalid_status_id_exceeding_2_chars () {
        assertThrows (DataIntegrityViolationException.class, () -> {
            statusRepo.save (new Status ("JAM", "Jammed"));
            statusRepo.findAll ();
        });
    }

    @Test
    @Transactional
    void test_add_invalid_status_name_exceeding_255_chars () {
        String longName = "KAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAHDSFLKJASHFDLKJASDHFLKAJSDHFLAKJFHAIUSFHALSUFHALWEFJHASLKDJFHASDLKJFHASDLKJFHASDLKJFHASDLKJFHALKSDFKAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAH";
        assertThrows (DataIntegrityViolationException.class, () -> {
            statusRepo.save (new Status ("JM", longName));
            statusRepo.findAll ();
        });
    }
}
