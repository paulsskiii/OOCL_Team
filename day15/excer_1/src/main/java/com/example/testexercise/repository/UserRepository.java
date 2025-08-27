package com.example.testexercise.repository;

import com.example.testexercise.model.User;

// --- UserRepository.java (Dependency) ---
public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
