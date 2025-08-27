package com.example.day12.repository;

import com.example.day12.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
}
