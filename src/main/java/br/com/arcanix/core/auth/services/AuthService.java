package br.com.arcanix.core.auth.services;

import br.com.arcanix.core.auth.dtos.LoginDTO;

public interface AuthService {
    String login(LoginDTO dto);
}
