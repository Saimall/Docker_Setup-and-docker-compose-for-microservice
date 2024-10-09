package com.example.springsecuirtydemo.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
	 

	public static String generateToken(String username) {
		HashMap<String, Object> claims = new HashMap<>();
		
		return createToken(claims,username);
	}

	private static String createToken(HashMap<String, Object> claims, String username) throws InvalidKeyException{
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+30*60*1000)).signWith(signingKey(),SignatureAlgorithm.HS256).compact();
		
		
		
		
//		return Jwts.builder().claims().add(claims).subject(username).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date( System.currentTimeMillis()+1000*60*30)).signWith(signingKey()).compact();
	}
	
	
	private static Key signingKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

	public static boolean validatetoken(String token) {
		//this method returns the clamis object and we are checjing it is not null to validate user
		//if below line excutes true then true will return other wise it will throw exception
		Jwts.parserBuilder().setSigningKey(signingKey()).build().parseClaimsJws(token) ;
		return true;
	}

}
