package br.com.arcanix.core.auth.services.impl;

import br.com.arcanix.core.auth.services.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    private final SecretKey key;

    public JwtServiceImpl(@Value("${JWT_SECRET}") String secret){
        this.key = Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    @Override
    public String generateToken(Authentication auth) {
        return Jwts.builder()
                .subject(auth.getName())
                .issuedAt(new Date())
                .expiration(new Date((System.currentTimeMillis()) + 360000))
                .signWith(key)
                .compact();
    }

    @Override
    public String extractSubject(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
