package com.g3w4.container_management_system.service;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import static org.springframework.test.util.ReflectionTestUtils.setField;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Encoders;

public class JwtServiceTest {

    private JwtService jwtService;
    private UserDetails userDetails;
    private String secretKey;
    private long jwtExpiration;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();

        secretKey = Encoders.BASE64.encode("this-is-a-secret-key-g3w4-capstone".getBytes());
        jwtExpiration = 1000 * 60 * 60;

        setField(jwtService, "secretKey", secretKey);
        setField(jwtService, "jwtExpiration", jwtExpiration);

        userDetails = User.builder()
                .username("testUsername")
                .password("testPassword")
                .roles("USER")
                .build();
    }

    @Test
    void test_given_user_provides_valid_credentials_when_logging_in_then_should_generate_a_valid_token() {
        String token = jwtService.generateToken(userDetails);

        assertNotNull(token);
        assertTrue(jwtService.isTokenValid(token, userDetails));
        assertEquals("testUsername", jwtService.extractUsername(token));
    }

    @Test
    void test_given_another_user_credential_is_provided_when_logging_in_then_should_return_false() {
        String token = jwtService.generateToken(userDetails);

        UserDetails anotherUser = User.builder()
                .username("otheruser")
                .password("password")
                .roles("USER")
                .build();

        assertFalse(jwtService.isTokenValid(token, anotherUser));
    }

    @Test
    void test_given_user_provides_valid_credentials_and_application_generates_valid_token_when_logging_in_but_already_expired_then_isTokenValid_should_return_false() throws InterruptedException {
        setField(jwtService, "jwtExpiration", 1000L); // 1 second expiration
        String token = jwtService.generateToken(userDetails);

        Thread.sleep(2000L);

        assertFalse(jwtService.isTokenValid(token, userDetails));
    }

    @Test
    void test_given_user_provides_valid_credentials_when_logging_in_then_application_should_return_correct_username_and_expiration_during_ExtractClaims() {
        String token = jwtService.generateToken(userDetails);

        String username = jwtService.extractUsername(token);
        Date expiration = jwtService.extractClaim(token, Claims::getExpiration);

        assertEquals("testUsername", username);
        assertNotNull(expiration);
    }
}
