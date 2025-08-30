package com.example.capstoneapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
public class UserLoginController {
    private final UserService userService;

    public UserLoginController (UserService userCredService) {
        this.userService = userCredService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> loginUser (@RequestBody UserCredential userCred) {
        Map<String, Object> loginResult;
        try {
            System.out.println (userCred);
            loginResult = userService.loginUser (userCred);

            if ((boolean) loginResult.get ("success"))
                return new ResponseEntity<> (loginResult, HttpStatus.OK);
            else {
                boolean isDBError = ((String) loginResult.get ("message")).toLowerCase ().contains ("error");
                return new ResponseEntity<> (loginResult, isDBError ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            loginResult = new HashMap<> ();
            loginResult.put ("success", false);
            loginResult.put ("message", "bad_error");

            e.printStackTrace();
            return new ResponseEntity<> (loginResult, HttpStatus.BAD_REQUEST);
        }
    }
}
