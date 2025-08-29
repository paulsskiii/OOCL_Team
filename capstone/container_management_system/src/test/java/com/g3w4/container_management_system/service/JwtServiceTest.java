package com.g3w4.container_management_system.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import static org.springframework.test.util.ReflectionTestUtils.getField;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class JwtServiceTest {

    private JwtService jwtService;
    private UserDetails userDetails;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();

        // Inject test values for secret key + expiration
        // (in a real SpringBootTest these come from application.properties)
        var secretKey = getField(JwtService.class, "secretKey");
        var jwtExpiration = getField(JwtService.class, "jwtExpiration");

        setField(jwtService, "secretKey", "ZmFrZVNlY3JldEtleUZvclRlc3QxMjM0NTY=");
        setField(jwtService, "jwtExpiration", 3600000);
    }

    @Test
    void testValidToken() {

    }
}
