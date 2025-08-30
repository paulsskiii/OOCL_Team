package com.g3w4.container_management_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3w4.container_management_system.dto.LoginUserDto;
import com.g3w4.container_management_system.dto.UserRegisterDTO;
import com.g3w4.container_management_system.model.Users;
import com.g3w4.container_management_system.response.LoginResponse;
import com.g3w4.container_management_system.service.AuthenticationService;
import com.g3w4.container_management_system.service.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Handles Registration and Login, generate JWT tokens
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    // Flow -> Register (/register) > Encrypts Password > Saves User to DB > Returns a JWT Token
    @PostMapping("/register")
    public ResponseEntity<Users> registerNewUser(@RequestBody UserRegisterDTO user) {
        Users registeredUser = authenticationService.register(user);

        return ResponseEntity.ok(registeredUser);
    }

    // Flow -> Login (/login) > Authenticates user > Generates and returns a JWT Token
    // Keep token expiry times short and rotate them often
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginUserDto loginUserDto) {
        Users authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

}
