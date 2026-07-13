package br.com.arcanix.core.pessoa.dtos;

import br.com.arcanix.core.pessoa.entities.Telefone;
import br.com.arcanix.core.pessoa.entities.enums.TipoParceiro;
import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;

import java.util.List;
import java.util.UUID;

public record ResponsePessoaDTO(UUID id,
                                String razaoSocial,
                                String nomeFantasia,
                                String cpf,
                                String cnpj,
                                TipoPessoa tipoPessoa,
                                List<Telefone> telefones,
                                List<TipoParceiro> tipoParceiro) {
}
