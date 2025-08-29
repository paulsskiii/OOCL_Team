package com.example.capstoneapplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.capstoneapplication.model.UserInformation;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long>{
    @Query(value="SELECT user_information.* FROM user_information, user_credentials WHERE user_information.email=?1 AND user_information.user_credentials_id=user_credentials.`id` AND user_credentials.is_active=1 LIMIT 1", nativeQuery = true)
    public Optional<UserInformation> findByActiveEmail (String email);
}
