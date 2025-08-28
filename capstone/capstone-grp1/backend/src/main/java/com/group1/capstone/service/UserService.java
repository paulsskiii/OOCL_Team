package com.group1.capstone.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.capstone.exceptions.UserNotFoundException;
import com.group1.capstone.model.User;
import com.group1.capstone.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 1. Find all User
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. Find User by ID
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
    }

    // 3. Get User count
    public long getUserCount() {
        return userRepository.count();
    }

    // 4. Add User
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // 5. Update User    
    public User updateUser(int id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            // status.setStatusType(updatedStatus.getStatusType());
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setRole(updatedUser.getRole());
            user.setPassword(updatedUser.getPassword());
            user.setContactNumber(updatedUser.getContactNumber());
            user.setUpdatedAt(LocalDateTime.now());

            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
    }
    
    // 6. Delete User
    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("user with ID " + id + " not found.");
        }
        userRepository.deleteById(id);
    }
}
