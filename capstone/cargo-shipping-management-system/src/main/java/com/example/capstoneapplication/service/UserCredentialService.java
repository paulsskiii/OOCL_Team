package com.example.capstoneapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstoneapplication.model.UserCredentials;
import com.example.capstoneapplication.repository.UserCredentialsRepository;

@Service
public class UserCredentialService {
    @Autowired
    UserCredentialsRepository userCredRepo;

    public UserCredentialService (UserCredentialsRepository userCredRepo) {
        this.userCredRepo = userCredRepo;
    }

    public boolean isUsernameNotExisting (UserCredentials userCred) {
        Optional<UserCredentials> returnedUser = userCredRepo.findByUsername (userCred.getUsername ());

        return returnedUser.isEmpty ();
    }

    public UserCredentials addUser (UserCredentials userCred) {
        if (this.isUsernameNotExisting (userCred))
            return userCredRepo.save (userCred);
        else
            return new UserCredentials (-1L, "Failed", "Failed", 0);
    }   
}
