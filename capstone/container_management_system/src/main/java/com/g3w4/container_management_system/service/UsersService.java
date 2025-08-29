package com.g3w4.container_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.model.Users;
import com.g3w4.container_management_system.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Transactional
    public Users registerUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }
}
