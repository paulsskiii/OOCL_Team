package com.example.capstoneapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long>{

}
