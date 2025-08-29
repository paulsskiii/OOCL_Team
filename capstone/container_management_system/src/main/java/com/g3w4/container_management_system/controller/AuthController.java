package com.g3w4.container_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.dto.UserRegisterDTO;
import com.g3w4.container_management_system.model.Users;
import com.g3w4.container_management_system.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    // Handles Registration and Login, generate JWT tokens
    @Autowired
    private UsersService usersService;
    
    // Flow -> Register (/register) > Encrypts Password > Saves User to DB > Returns a JWT Token
    @PostMapping("/register")
    public ResponseEntity<Users> registerNewUser(@RequestBody UserRegisterDTO user) {
        return ResponseEntity.ok(usersService.registerUser(user));
    }
    // Flow -> Login (/login) > Authenticates user > Generates and returns a JWT Token
    // Keep token expiry times short and rotate them often
}
