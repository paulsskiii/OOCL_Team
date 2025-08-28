package com.example.capstoneapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.Port;

@Repository
public interface PortsRepository extends JpaRepository<Port, String> {
    
}
