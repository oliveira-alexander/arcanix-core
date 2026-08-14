package br.com.arcanix.core.usuario.services;

import br.com.arcanix.core.usuario.dtos.CreateUsuarioDTO;

public interface UsuarioService {

    String create(CreateUsuarioDTO dto);
}
