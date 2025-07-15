package com.prashant.microservice.auth_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import com.prashant.microservice.auth_service.jwt.JwtService;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTest {

    private JwtService jwtService;

    @Mock
    private UserDetails userDetails;

    @BeforeEach
    void setup() {

        jwtService = new JwtService("12345678901234567890123456789012", 1000 * 60 * 60);
    }

    @Test
    void generateTokenShouldGenerateToken() {
        String email = "Amy@email.com";
        when(userDetails.getUsername()).thenReturn(email);

        String token = jwtService.generateToken(userDetails);

        assertNotNull(token);
        System.out.println("Generated Token: " + token);
    }

    @Test
    void extractUsernameShouldExtractUsername() {
        String email = "Amy@email.com";
        when(userDetails.getUsername()).thenReturn(email);

        String token = jwtService.generateToken(userDetails);
        String extracted = jwtService.extractUsername(token);

        assertEquals(email, extracted);
    }
}
