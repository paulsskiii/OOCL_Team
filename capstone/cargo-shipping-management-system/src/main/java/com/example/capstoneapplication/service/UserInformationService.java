package com.example.capstoneapplication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstoneapplication.model.UserInformation;
import com.example.capstoneapplication.repository.UserInformationRepository;

@Service
public class UserInformationService {
    @Autowired
    UserInformationRepository userInfoRepo;

    public UserInformationService (UserInformationRepository userInfoRepo) {
        this.userInfoRepo = userInfoRepo;
    }

    public boolean isEmailNotExisting (String email) {
        Optional<UserInformation> returnedUser = userInfoRepo.findByEmail(email);

        return returnedUser.isEmpty ();
    }

    public UserInformationRepository addUserInfo (UserInformation userInfo) {
        if (this.isEmailNotExisting(userInfo.getEmail ()))
            return UserInfoRepo.save (userInfo);
    }
}
