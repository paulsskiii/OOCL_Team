package com.g3w4.container_management_system.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.dto.LoginUserDto;
import com.g3w4.container_management_system.model.Users;
import com.g3w4.container_management_system.repository.UsersRepository;

@Service
public class AuthenticationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UsersRepository usersRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager
    ) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public Users authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUserDto.getUsername(), loginUserDto.getPassword())
        );

        return usersRepository.findByUsername(loginUserDto.getUsername())
                .orElseThrow();
    }
}
