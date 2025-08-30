package com.example.capstoneapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class UserLoginController {
    private final UserService userService;

    public UserLoginController (UserService userCredService) {
        this.userService = userCredService;
    }

    @PostMapping
    public ResponseEntity<Long> loginUser (@RequestBody UserCredential userCred) {
        return null;
    }
    
}
