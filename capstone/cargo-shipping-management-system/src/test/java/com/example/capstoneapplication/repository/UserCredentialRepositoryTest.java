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

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.repository.UserCredentialRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserCredentialRepositoryTest {
    @Autowired
    UserCredentialRepository userCredRepo;

    private List<UserCredential> expectedUserCreds;


    @BeforeEach
    void setup () {
        expectedUserCreds = new ArrayList<UserCredential> ();
        expectedUserCreds.add (new UserCredential ("test", "test_password", 1));
        expectedUserCreds.add (new UserCredential ("test2", "test_password", 1));
    }

    @Test
    @Transactional
    void test_add_valid_user () {
        UserCredential createdUserCred = userCredRepo.save (expectedUserCreds.get (0));

        assertEquals (1, userCredRepo.findAll ().size ());
        
        expectedUserCreds.get (0).setId (1L);
        assertEquals (expectedUserCreds.get (0), createdUserCred);
    }

    @Test
    @Transactional
    void test_add_existing_username () {
        userCredRepo.save (expectedUserCreds.get (0));
        userCredRepo.save (expectedUserCreds.get (0));

        assertEquals(1, userCredRepo.findAll ().size ());
    }

    @Test
    @Transactional
    void test_add_user_exceeding_255_chars () {
        String longName = "KAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAHDSFLKJASHFDLKJASDHFLKAJSDHFLAKJFHAIUSFHALSUFHALWEFJHASLKDJFHASDLKJFHASDLKJFHASDLKJFHASDLKJFHALKSDFKAKUEHFALKSDJFHALKDSJFHALKDSJFHALKSDJFHADLKFJHADSLKFJHASDLKFJHASDLKFJAHSDFLKJAH";
        assertThrows (DataIntegrityViolationException.class, () -> {
            userCredRepo.save (new UserCredential (longName, "test_password", 1));
            userCredRepo.save (new UserCredential ("test", longName, 1));
            userCredRepo.findAll ();
        });
    }

    // @Test
    // @Transactional
    // void test_remove_existing_user () {
    //     userCredRepo.save (expectedUserCreds.get (0));
    //     userCredRepo.save (expectedUserCreds.get (1));

    //     assertEquals (2, userCredRepo.findAll ().size ());
        
    // }
    
}
