package com.example.demo;

// --- main.UserRepository.java (Dependency) ---
// We will mock this interface
public interface UserRepository {
    User findByEmail(String email);

    User save(User user);
}
