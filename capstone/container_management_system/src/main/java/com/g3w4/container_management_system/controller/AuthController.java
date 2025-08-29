package com.g3w4.container_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    // Handles Registration and Login, generate JWT tokens

    // Flow -> Register (/register) > Encrypts Password > Saves User to DB > Returns a JWT Token
    // Flow -> Login (/login) > Authenticates user > Generates and returns a JWT Token
    // Keep token expiry times short and rotate them often
}
