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
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class UserLoginController {
    private final UserCredentialService userCredService;

    public UserLoginController (UserCredentialService userCredService) {
        this.userCredService = userCredService;
    }

    @PostMapping
    public ResponseEntity<Long> loginUser (@RequestBody UserCredentials userCred) {
        UserCredentials returnedUser = userCredService.findByUser (userCred);
        return new ResponseEntity<> (returnedUser.getId (), returnedUser.getIsActive () > 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    
}
