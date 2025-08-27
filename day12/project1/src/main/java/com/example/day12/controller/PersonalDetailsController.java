package com.example.day12.controller;

import com.example.day12.model.PersonalDetails;
import com.example.day12.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personal-details")
@CrossOrigin(origins = "http://localhost:3000/") // Moved to class level for best practice
public class PersonalDetailsController {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    @PostMapping("/") // Added a path to ensure it maps correctly
    public PersonalDetails savePersonalDetails(@RequestBody PersonalDetails personalDetails) {
        // The save() method from JpaRepository saves the new object to the database.
        return personalDetailsRepository.save(personalDetails);
    }
}