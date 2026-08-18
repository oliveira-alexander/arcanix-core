package br.com.arcanix.core.auth.controllers;

import br.com.arcanix.core.auth.dtos.LoginDTO;
import br.com.arcanix.core.auth.services.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO dto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(authService.login(dto));
    }

    @PostMapping("/key")
    public ResponseEntity<String> key(){
        SecretKey key = Jwts.SIG.HS256.key().build();

        String secret = Encoders.BASE64.encode(key.getEncoded());

        return ResponseEntity.status(HttpStatus.OK)
                .body(secret);
    }
}
