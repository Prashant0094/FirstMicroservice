package com.prashant.microservice.auth_service.dto;

public class AuthenticationResponse {

	private String token;
	
	public AuthenticationResponse() {}

	public AuthenticationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
