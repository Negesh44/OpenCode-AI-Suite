package com.oaes.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    // Change this to a secure key in production
    private static final String SECRET =
            "ThisIsASecretKeyForOAESJwtAuthenticationSystem2026SecureKey";

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Token validity (24 hours)
    private static final long JWT_EXPIRATION = 1000 * 60 * 60 * 24;

    /**
     * Generate JWT Token
     */
    public String generateToken(String email) {

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(key)
                .compact();
    }

    /**
     * Extract email from token
     */
    public String extractEmail(String token) {

        return extractClaims(token).getSubject();
    }

    /**
     * Validate token
     */
    public boolean isTokenValid(String token, String email) {

        String extractedEmail = extractEmail(token);

        return extractedEmail.equals(email) && !isTokenExpired(token);
    }

    /**
     * Check expiration
     */
    private boolean isTokenExpired(String token) {

        return extractClaims(token)
                .getExpiration()
                .before(new Date());
    }

    /**
     * Read claims
     */
    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}