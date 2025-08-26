package com.example.day15_activity1.repository;

import com.example.day15_activity1.model.User;

// We will mock this interface
public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
