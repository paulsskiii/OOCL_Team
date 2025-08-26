package com.example.testing;

public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}

