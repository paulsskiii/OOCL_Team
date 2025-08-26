package com.day15test.testing;

public interface UserRepository {
    User findByEmail(String email);
    User save(User user);
}
