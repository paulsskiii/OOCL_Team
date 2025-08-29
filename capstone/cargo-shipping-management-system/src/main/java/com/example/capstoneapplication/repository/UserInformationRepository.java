package com.example.capstoneapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long>{
    public Optional<UserInformation> findByEmail (String email);
}
