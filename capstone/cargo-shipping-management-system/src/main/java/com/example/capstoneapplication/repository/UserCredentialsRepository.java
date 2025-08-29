package com.example.capstoneapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    
    @Query(value="SELECT * FROM user_credentials WHERE username=?1 AND is_active=1 LIMIT 1", nativeQuery = true)
    public Optional<UserCredentials> findByActiveUsername (String username);
    public Optional<UserCredentials> findByUsernameAndPassword (String username, String password);

    @Query(value="SELECT * FROM user_credentials WHERE username=?1 AND password=?2 AND is_active=1 LIMIT 1", nativeQuery = true)
    public Optional<UserCredentials> findActiveUser (String username, String password);
}
