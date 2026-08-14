package br.com.arcanix.core.usuario.dtos;

public record CreateUsuarioDTO(String email,
                               String password,
                               Long pessoaId) {
}
