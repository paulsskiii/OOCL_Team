package com.example.test.repository;

import com.example.test.model.User;

public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
