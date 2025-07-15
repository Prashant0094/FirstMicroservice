package com.prashant.microservice.auth_service.jwt;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.common.model.jwt.JwtUtils;

@Service
public class JwtService {

	public JwtService(String string, int i) {
	
	}


	public String generateToken(UserDetails userDetails) {
	    return JwtUtils.generateToken(userDetails.getUsername());
	}


    public String extractUsername(String token) {
        return JwtUtils.extractUsername(token);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && JwtUtils.validate(token));
    }
}
