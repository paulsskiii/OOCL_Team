package com.example.day15_activity1.repository;

import com.example.day15_activity1.model.User;

public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
