package br.com.arcanix.core.pessoa.dtos;

import br.com.arcanix.core.pessoa.entities.Telefone;
import br.com.arcanix.core.pessoa.entities.enums.TipoParceiro;
import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreatePessoaDTO(@NotNull
                              @NotBlank
                              @Size(max = 100, message = "O tamanho máximo da Razão Social é de 100 caracteres!")
                              @Size(min = 5, message = "O tamanho mínimo da Razão Social é de 5 caracteres!")
                                String razaoSocial,
                              @NotNull
                              @NotBlank
                              @Size(max = 100, message = "O tamanho máximo da Razão Social é de 100 caracteres!")
                              @Size(min = 5, message = "O tamanho mínimo da Razão Social é de 5 caracteres!")
                                String nomeFantasia,
                              @Size(min = 14, max = 14, message = "O tamanho do CPF é de 14 caracteres!")
                                String cpf,
                              @Size(min = 16, max = 16, message = "O tamanho do CNPJ é de 16 caracteres!")
                                String cnpj,
                              @NotNull (message = "Informe um Tipo de Pessoa válido!")
                                TipoPessoa tipoPessoa,
                                List<CreateTelefoneDTO> telefones,
                              @NotNull
                                List<TipoParceiro> tipoParceiro)
{}
