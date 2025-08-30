package com.g3w4.container_management_system.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.dto.LoginUserDto;
import com.g3w4.container_management_system.dto.UserRegisterDTO;
import com.g3w4.container_management_system.model.Customer;
import com.g3w4.container_management_system.model.Roles;
import com.g3w4.container_management_system.model.Users;
import com.g3w4.container_management_system.repository.UsersRepository;

import jakarta.transaction.Transactional;

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

    // User Registration
    @Transactional
    public Users register(UserRegisterDTO userRegisterDTO) {
        Users user = new Users();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        Customer customer = new Customer();
        customer.setFirstName(userRegisterDTO.getFirstName());
        customer.setLastName(userRegisterDTO.getLastName());
        customer.setEmail(userRegisterDTO.getEmail());
        customer.setContactNo(userRegisterDTO.getContactNo());
        user.setCustomer(customer);

        Roles role = new Roles();
        role.setRoleId(2);
        role.setRoleName("USER");
        user.setRole(role);

        return usersRepository.save(user);
    }

    // Login
    public Users authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUserDto.getUsername(), loginUserDto.getPassword())
        );

        return usersRepository.findByUsername(loginUserDto.getUsername())
                .orElseThrow();
    }
}
