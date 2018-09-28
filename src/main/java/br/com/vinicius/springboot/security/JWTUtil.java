package br.com.vinicius.springboot.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private String expirition;
	
	public String generateToken(String username) {
		long millis = System.currentTimeMillis() + Long.parseLong(expirition);
		Date exp = new Date(millis);
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(exp)
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
	
}
