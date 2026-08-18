package br.com.arcanix.core.auth.services.impl;

import br.com.arcanix.core.auth.dtos.LoginDTO;
import br.com.arcanix.core.auth.services.AuthService;
import br.com.arcanix.core.auth.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(LoginDTO dto) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

        Authentication auth = authenticationManager.authenticate(authToken);

        return jwtService.generateToken(auth);
    }


}
