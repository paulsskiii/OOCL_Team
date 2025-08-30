package com.example.capstoneapplication.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.model.UserInformation;

import jakarta.transaction.Transactional;

@SpringBootTest 
public class UserInformationRepositoryTest {
    @Autowired
    UserInformationRepository userInfoRepo;

    @Autowired
    UserCredentialRepository userCredRepo;

    private List<UserInformation> expectedUserInfos;

    @BeforeEach
    @Transactional
    void setup () {
        expectedUserInfos = new ArrayList<UserInformation> ();
        expectedUserInfos.add (new UserInformation ("testuser@gmail.com", "+639236439243", 1L));
        expectedUserInfos.add (new UserInformation ("testuser2@gmail.com", "+639174439315", 2L));
        
        List<UserCredential> expectedUserCreds = new ArrayList<UserCredential> ();
        expectedUserCreds.add (new UserCredential ("test", "test_password", 1));
        expectedUserCreds.add (new UserCredential ("test2", "test_password", 1));

        userCredRepo.save (expectedUserCreds.get (0));
        userCredRepo.save (expectedUserCreds.get (1));
    }

    @Test
    @Transactional
    @Sql(statements = "ALTER TABLE user_credentials AUTO_INCREMENT=1")
    void test_add_valid_user_information () {
        UserInformation createdUserInfo = userInfoRepo.save (expectedUserInfos.get (0));

        assertEquals (1, userInfoRepo.findAll ().size ());
        
        expectedUserInfos.get (0).setId (1L);
        assertEquals (expectedUserInfos.get (0), createdUserInfo);
    }

    @Test
    @Transactional
    @Sql(statements = "ALTER TABLE user_credentials AUTO_INCREMENT=1")
    void test_add_existing_email () {
        userInfoRepo.save (expectedUserInfos.get (0));
        userInfoRepo.save (expectedUserInfos.get (0));

        assertEquals(1, userInfoRepo.findAll ().size ());
    }

    // @Test
    // @Transactional
    // void test_remove_existing_user () {
    //     userInfoRepo.save (expectedUserCreds.get (0));
    //     userInfoRepo.save (expectedUserCreds.get (1));

    //     assertEquals (2, userInfoRepo.findAll ().size ());
        
    // }
    
}
