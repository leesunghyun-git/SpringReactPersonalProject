package com.sist.web.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64.Decoder;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Component
@RequiredArgsConstructor
public class JwtProvider {
	private final JwtProperties jwtProperties;
	private SecretKey secret;
	
	@PostConstruct
	public void init() {	    
		secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.getSecret()));
	}
	
	public String createRefreshToken(String username) {
		Date now = new Date();
		Date expiry = new Date(
			now.getTime()+jwtProperties.getRefreshTokenExpiration()
		);
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(now)
				.setExpiration(expiry)
				.signWith(secret,SignatureAlgorithm.HS256)
				.compact();
	}
	private Claims parseClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(secret)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	public String getUsername(String token) {
		return parseClaims(token).getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			parseClaims(token);
			return true;
			
		}catch(JwtException | IllegalArgumentException ex)
		{
			ex.printStackTrace();
			return false;
			
		}
	}
}
