package com.example.utility;





import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility {

	private String SECRET="mysecretkey";
	
	
	public String generateToken(String username) {
		
		
		return Jwts.builder().
				setSubject(username).
				setIssuedAt(new Date()).
				setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)).
				signWith(SignatureAlgorithm.HS256,SECRET).compact()
				;
	}
	
	public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token));
    }
	
}
