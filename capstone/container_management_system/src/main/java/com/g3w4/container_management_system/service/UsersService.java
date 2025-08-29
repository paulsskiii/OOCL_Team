package com.g3w4.container_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.g3w4.container_management_system.dto.UserRegisterDTO;
import com.g3w4.container_management_system.model.Customer;
import com.g3w4.container_management_system.model.Roles;
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
    public Users registerUser(UserRegisterDTO input) {
        Users user = new Users();
        user.setUsername(input.getUsername());
        user.setPassword(encoder.encode(input.getPassword()));

        Customer customer = new Customer();
        customer.setFirstName(input.getFirstName());
        customer.setLastName(input.getLastName());
        customer.setEmail(input.getEmail());
        customer.setContactNo(input.getContactNo());
        user.setCustomer(customer);

        Roles role = new Roles();
        role.setRoleId(2);
        role.setRoleName("user");
        user.setRole(role);
          
        return usersRepository.save(user);
    }
}
