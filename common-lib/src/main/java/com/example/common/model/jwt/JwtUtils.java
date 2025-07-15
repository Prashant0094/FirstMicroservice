package com.example.common.model.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.security.Key;

public class JwtUtils {

	private static final String SECRET = "your-super-long-256-bit-secret-key-for-jwt-which-is-safe";
	private static final long EXPIRATION = 60 * 60 * 1000; // 1 hour

	private static Key getSignKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public static String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)).signWith(getSignKey()).compact();
	}

	public static String extractUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody().getSubject();
	}

	public static boolean validate(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}
}
