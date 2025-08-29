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
        Optional<UserInformation> returnedUser = userInfoRepo.findByActiveEmail(email);

        return returnedUser.isEmpty ();
    }

    public UserInformation addUserInfo (UserInformation userInfo) {
        try {
            if (this.isEmailNotExisting(userInfo.getEmail ()))
                return userInfoRepo.save (userInfo);
            else
                return new UserInformation (-1L, "existing User", "existing User", -1L);
        } catch (Exception e) {
            e.printStackTrace ();
            return new UserInformation (-999L, "error", "error", -999L);
        }
    }
}
