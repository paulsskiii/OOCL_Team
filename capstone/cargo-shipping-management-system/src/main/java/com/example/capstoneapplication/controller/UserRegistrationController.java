package com.example.capstoneapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneapplication.model.UserCredentials;
import com.example.capstoneapplication.service.UserCredentialService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegistrationController {
    private final UserCredentialService userCredService;

    public UserRegistrationController (UserCredentialService userCredService) {
        this.userCredService = userCredService;
    }

    @PostMapping
    public ResponseEntity<UserCredentials> registerUser (@RequestBody UserCredentials userCred) {
        UserCredentials createdUser = userCredService.registerUser (userCred);
        if (createdUser.getId () < 0L) {
            if (createdUser.getUsername ().toLowerCase ().equals ("error"))
                return new ResponseEntity<> (createdUser, HttpStatus.INTERNAL_SERVER_ERROR);
            else if (createdUser.getUsername ().toLowerCase ().equals ("exist"))
                return new ResponseEntity<> (createdUser, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<> (createdUser, HttpStatus.OK);
    }
    




}
