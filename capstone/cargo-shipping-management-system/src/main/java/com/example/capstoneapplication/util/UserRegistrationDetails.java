package com.example.capstoneapplication.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationDetails {
    private String username;
    private String password;
    private String email;
    private String contactNumber;
}
