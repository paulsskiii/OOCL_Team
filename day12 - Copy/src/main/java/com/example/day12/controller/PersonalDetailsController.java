package com.example.day12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.day12.model.PersonalDetails;
import com.example.day12.repository.PersonalDetailsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/personal-details")
@CrossOrigin // Moved to class level for best practice
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    // POST http://localhost:8080/api/personal-details
    @PostMapping // Added a path to ensure it maps correctly
    public PersonalDetails addPersonalDetails(@RequestBody PersonalDetails personalDetails) {
        // The save() method from JpaRepository saves the new object to the database.
        return personalDetailsRepository.save(personalDetails);
    }

    @GetMapping
    public List<PersonalDetails> getAllPersonalDetails() {
        return personalDetailsRepository.findAll();
    }
    
}