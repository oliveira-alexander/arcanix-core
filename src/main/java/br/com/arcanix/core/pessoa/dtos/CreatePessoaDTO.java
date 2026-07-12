package br.com.arcanix.core.pessoa.dtos;

import br.com.arcanix.core.pessoa.entities.Telefone;
import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;

import java.util.List;

public record CreatePessoaDTO(String razaoSocial,
                              String nomeFantasia,
                              String cpf,
                              String cnpj,
                              TipoPessoa tipoPessoa,
                              List<Telefone> telefones)
{}
