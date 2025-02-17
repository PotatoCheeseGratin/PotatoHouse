package com.potatocountry.potatocountry.global.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil {
	private static final String USERNAME = "username";
	private static final String ROLE = "role";

	private final SecretKey secretKey;
	private final Long expiredTimeMillis;

	public JWTUtil(@Value("${spring.jwt.secret}") String secret,
		@Value("${spring.jwt.expiration.access}") Long expiredTimeMillis) {
		this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
			Jwts.SIG.HS256.key().build().getAlgorithm());
		this.expiredTimeMillis = expiredTimeMillis;
	}

	public String getUsername(String token) {
		return Jwts.parser()
			.verifyWith(secretKey)
			.build()
			.parseSignedClaims(token)
			.getPayload()
			.get(USERNAME, String.class);
	}

	public String getRole(String token) {
		return Jwts.parser()
			.verifyWith(secretKey)
			.build()
			.parseSignedClaims(token)
			.getPayload()
			.get(ROLE, String.class);
	}

	public Boolean isExpired(String token) {
		return Jwts.parser()
			.verifyWith(secretKey)
			.build()
			.parseSignedClaims(token)
			.getPayload()
			.getExpiration()
			.before(new Date());
	}

	public String createJwt(String username, String role) {
		return Jwts.builder()
			.claim(USERNAME, username)
			.claim(ROLE, role)
			.issuedAt(new Date(System.currentTimeMillis()))
			.expiration(new Date(System.currentTimeMillis() + expiredTimeMillis))
			.signWith(secretKey)
			.compact();
	}
}
