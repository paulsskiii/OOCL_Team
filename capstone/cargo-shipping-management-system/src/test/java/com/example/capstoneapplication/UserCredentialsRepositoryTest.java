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

import com.example.capstoneapplication.model.UserCredentials;
import com.example.capstoneapplication.repository.UserCredentialsRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UserCredentialsRepositoryTest {
    @Autowired
    UserCredentialsRepository userCredRepo;

    private List<UserCredentials> expectedUserCreds;


    @BeforeEach
    void setup () {
        expectedUserCreds = new ArrayList<UserCredentials> ();
        expectedUserCreds.add (new UserCredentials ("test", "test_password", 1));
        expectedUserCreds.add (new UserCredentials ("test2", "test_password", 1));
    }

    @Test
    @Transactional
    void test_add_valid_user () {
        UserCredentials createdUserCred = userCredRepo.save (expectedUserCreds.get (0));

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
            userCredRepo.save (new UserCredentials (longName, "test_password", 1));
            userCredRepo.save (new UserCredentials ("test", longName, 1));
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
