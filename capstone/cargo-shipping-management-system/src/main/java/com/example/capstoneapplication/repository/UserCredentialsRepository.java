package com.example.capstoneapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
    
}
