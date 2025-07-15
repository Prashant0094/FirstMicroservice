package com.prashant.microservice.auth_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.TestPropertySource;

import com.prashant.microservice.auth_service.dto.AuthenticationRequest;
import com.prashant.microservice.auth_service.dto.AuthenticationResponse;
import com.prashant.microservice.auth_service.jwt.JwtService;
import com.prashant.microservice.auth_service.security.CustomUserDetailsService;

@ExtendWith(MockitoExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")

public class AuthServiceTest {
	
	@InjectMocks 
	AuthService authService;
	
	@Mock
	CustomUserDetailsService detailsService;
	
	@Mock
	JwtService jwtService;
	
	@Mock 
	AuthenticationManager authManager;
	
	@Test
	void login_authenticateAndReturnJwt_whenUserNamePasswordExistAndMatch() {
		AuthenticationRequest response = new AuthenticationRequest("Any@email.com","password");
		
		UserDetails mockUser = mock(UserDetails.class);
		//when(mockUser.getUsername()).thenReturn("Any@email.com");
		
		when(detailsService.loadUserByUsername("Any@email.com")).thenReturn(mockUser);
		when(jwtService.generateToken(mockUser)).thenReturn("JWT-generated-token");
		
		AuthenticationResponse result = authService.login(response);
		
		assertNotNull(result);
		assertEquals("JWT-generated-token",result.getToken());
		
		verify(authManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
		verify(detailsService).loadUserByUsername("Any@email.com");
		verify(jwtService).generateToken(mockUser);
	}
}
