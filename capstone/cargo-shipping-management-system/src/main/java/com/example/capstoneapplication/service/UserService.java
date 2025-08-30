package com.example.capstoneapplication.service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.model.UserInformation;
import com.example.capstoneapplication.repository.UserCredentialRepository;
import com.example.capstoneapplication.repository.UserInformationRepository;

@Service
public class UserService {
    @Autowired
    UserCredentialRepository userCredRepo;

    @Autowired
    UserInformationRepository userInfoRepo;

    public UserService (UserCredentialRepository userCredRepo, UserInformationRepository userInfoRepo) {
        this.userCredRepo = userCredRepo;
        this.userInfoRepo = userInfoRepo;
    }

    public UserCredential findActiveUsername (String username) {
        try {
            Optional<UserCredential> foundUser = userCredRepo.findByActiveUsername (username);
            return foundUser.get ();
        } catch (NoSuchElementException e) {
            return new UserCredential (-1L, "none", "none", 0);
        }
         catch (Exception e) {
            e.printStackTrace ();
            return new UserCredential (-1001L, "error", "error", 0);
        }
    }

    public UserInformation findActiveEmail (String email) {
        try {
            Optional<UserInformation> foundUser = userInfoRepo.findByActiveEmail (email);
            return foundUser.get ();
        } catch (NoSuchElementException e) {
            return new UserInformation (-1L, "none", "none", -1L);
        } catch (Exception e) {
            e.printStackTrace ();
            return new UserInformation (-1001L, "error", "error", -1001L);
        }
    }

    public Map<String, Object> checkIfAllowedRegister (UserCredential userCred, UserInformation userInfo) {
        Map<String, Object> allowRegister = new HashMap<> ();
        try {
            UserCredential foundCredential = this.findActiveUsername (userCred.getUsername ());
            UserInformation foundInformation = this.findActiveEmail (userInfo.getEmail ());

            if (foundCredential.getId () == -1L && foundInformation.getId () == -1L) {
                allowRegister.put ("isAllowed", true);
            } else {
                allowRegister.put ("isAllowed", false);
                if (foundCredential.getId () >= 0L || foundInformation.getId () >= 0L) {
                    allowRegister.put ("reason", "taken");
                    allowRegister.put ("field", foundCredential.getId () >= 0L ? "username" : "email");
                } else {
                    allowRegister.put ("reason", "error");
                }
            }
        } catch (Exception e) {
            e.printStackTrace ();
            allowRegister.put ("isAllowed", false);
            allowRegister.put ("reason", "error");
        }

        return allowRegister;
    }

    public Map<String, Object> registerUser (UserCredential userCred, UserInformation userInfo) {
        Map<String, Object> checkResult = this.checkIfAllowedRegister(userCred, userInfo);
        Map<String, Object> registerResult = new HashMap<> ();
        boolean isRegisterAllowed = (boolean) checkResult.get ("isAllowed");
        String dbErrorMsg = "db_error";

        try {
            if (!isRegisterAllowed) {
                registerResult.put ("success", false);
                String reason = (String) checkResult.get ("reason");

                if ("taken".equals (reason)) {
                    String takenMsg = "username".equals (checkResult.get ("field")) ? "username_conflict" : "email_conflict";
                    registerResult.put ("message", takenMsg);
                } else if ("error".equals (reason))
                    registerResult.put ("message", dbErrorMsg);
            } else {
                UserCredential createdCred = userCredRepo.save (userCred);
                userInfo.setUserCredentialsId (createdCred.getId ());
                userInfoRepo.save (userInfo);
                registerResult.put ("success", true);
                registerResult.put ("message", "user_created");
            }
        } catch (Exception e) {
            registerResult.put ("success", false);
            registerResult.put ("message", dbErrorMsg);

            e.printStackTrace();
        }

        return registerResult;
    }


    public Map<String, Object> loginUser (UserCredential userCred) {
        Map<String, Object> loginResult = new HashMap<> ();
        String dbErrorMsg = "db_error";

        try {
            Optional<UserCredential> foundUser = userCredRepo.findByActiveUsernamePassword (userCred.getUsername (), userCred.getPassword ());
            boolean isActiveUserFound = foundUser.isPresent ();

            if (isActiveUserFound) {
                loginResult.put ("success", true);
                loginResult.put ("message", "user_found");
                loginResult.put ("token", "asdf123");
            } else {
                loginResult.put ("success", false);
                loginResult.put ("message", "user_not_found");
            }
        } catch (Exception e) {
            loginResult.put ("success", false);
            loginResult.put ("message", dbErrorMsg);

            e.printStackTrace ();
        }

        return loginResult;
    }
}