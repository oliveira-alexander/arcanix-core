package br.com.arcanix.core.pessoa.dtos;

import br.com.arcanix.core.pessoa.entities.enums.TipoTelefone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateTelefoneDTO(
                                @NotNull
                                @NotBlank
                                UUID id,
                                @NotNull
                                TipoTelefone tipoTelefone,
                                @NotNull
                                @NotBlank
                                @Size(min = 11, message = "O telefone deve ter no mínimo 11 caracteres!")
                                @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres!")
                                String numero) {
}
