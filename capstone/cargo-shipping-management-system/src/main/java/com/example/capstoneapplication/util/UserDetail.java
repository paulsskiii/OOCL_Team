package com.example.capstoneapplication.util;

import com.example.capstoneapplication.model.UserCredential;
import com.example.capstoneapplication.model.UserInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    private UserCredential userCred;
    private UserInformation userInfo;
}
