package com.example.capstoneapplication.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.capstoneapplication.repository.UserInformationRepository;

@ExtendWith(MockitoExtension.class)
public class UserInformationServiceTest {
    @Mock
    private UserInformationRepository userInfoRepo;

    @InjectMocks
    private UserInformationService userInfoService;

    @Test
    void test_add_new_information () {
        when (userInfoRepo)
    }
}
