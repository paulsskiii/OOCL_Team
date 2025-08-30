package com.example.capstoneapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.model.UserInformation;
import com.example.capstoneapplication.service.UserService;
import com.example.capstoneapplication.util.UserRegistrationDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:3000")
public class UserRegistrationController {
    private final UserService userService;

    public UserRegistrationController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerUser (@RequestBody UserRegistrationDetails userDetail) {
        Map<String, Object> registerResult;
        try {
            UserCredential userCred = new UserCredential (userDetail.getUsername (), userDetail.getPassword (), 1);
            UserInformation userInfo = new UserInformation (userDetail.getEmail (), userDetail.getContactNumber (), -1L);
            
            registerResult = userService.registerUser (userCred, userInfo);

            if ((boolean) registerResult.get ("success"))
                return new ResponseEntity<> (registerResult, HttpStatus.CREATED);
            else {
                boolean isDBError = ((String) registerResult.get ("message")).toLowerCase ().contains ("error");
                return new ResponseEntity<> (registerResult, isDBError ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            registerResult = new HashMap<> ();
            registerResult.put ("success", false);
            registerResult.put ("message", "bad_error");

            e.printStackTrace();
            return new ResponseEntity<> (registerResult, HttpStatus.BAD_REQUEST);
        }
    }
}
