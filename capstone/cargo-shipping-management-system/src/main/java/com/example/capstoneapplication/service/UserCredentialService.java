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
        Optional<UserCredentials> returnedUser = userCredRepo.findByActiveUsername (userCred.getUsername ());

        return returnedUser.isEmpty ();
    }

    public UserCredentials registerUser (UserCredentials userCred) {
        try {    
            if (this.isUsernameNotExisting (userCred))
                return userCredRepo.save (userCred);
            else
                return new UserCredentials (-1L, "exist", "exist", 0);
        } catch (Exception e) {
            e.printStackTrace ();
            return new UserCredentials (-1L, "error", "error", 0);
        }
    }

    public UserCredentials findByUser (UserCredentials userCred) {
        Optional<UserCredentials> returnedUser = userCredRepo.findActiveUser (userCred.getUsername (), userCred.getPassword ());
        if (returnedUser.isEmpty ())
            return new UserCredentials (-1L, "none", "none", 0);
        
        return returnedUser.get ();
    }
}
