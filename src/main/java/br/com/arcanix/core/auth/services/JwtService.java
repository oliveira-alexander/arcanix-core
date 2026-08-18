package br.com.arcanix.core.auth.services;

import org.springframework.security.core.Authentication;

public interface JwtService {
    String generateToken(Authentication auth);

    String extractSubject(String token);
}
