package br.com.arcanix.core.pessoa.dtos;

import br.com.arcanix.core.pessoa.entities.enums.TipoTelefone;

import java.util.UUID;

public record ResponseTelefoneDTO(UUID id,
                                  TipoTelefone tipoTelefone,
                                  String numero) {
}
