package com.example;
public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
