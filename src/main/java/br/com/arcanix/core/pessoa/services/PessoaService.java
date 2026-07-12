package br.com.arcanix.core.pessoa.services;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.ResponsePessoaDTO;

public interface PessoaService {
    ResponsePessoaDTO create(CreatePessoaDTO dto);
}
