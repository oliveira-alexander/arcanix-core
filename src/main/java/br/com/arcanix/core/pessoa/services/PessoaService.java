package br.com.arcanix.core.pessoa.services;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.ResponsePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.UpdatePessoaDTO;

import java.util.List;

public interface PessoaService {
    ResponsePessoaDTO create(CreatePessoaDTO dto);
    ResponsePessoaDTO update(Long id, UpdatePessoaDTO dto);
    void delete(Long id);
    List<ResponsePessoaDTO> findAll();
}
