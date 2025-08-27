package com.example.day15;

public interface UserRepository {
   User findByEmail(String email);
   User save(User user);
}
