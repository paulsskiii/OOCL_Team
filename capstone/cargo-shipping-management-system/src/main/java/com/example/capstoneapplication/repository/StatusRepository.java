package com.example.capstoneapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, String> {
    
}
