package com.tdd.day14;
public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}