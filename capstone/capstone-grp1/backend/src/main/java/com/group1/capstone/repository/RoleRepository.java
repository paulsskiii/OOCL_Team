package com.group1.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group1.capstone.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    
}
