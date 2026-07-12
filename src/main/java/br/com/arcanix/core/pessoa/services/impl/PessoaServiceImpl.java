package br.com.arcanix.core.pessoa.services.impl;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.ResponsePessoaDTO;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.mapper.PessoaMapper;
import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.pessoa.services.PessoaService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    public PessoaServiceImpl(PessoaRepository repository,
                             PessoaMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ResponsePessoaDTO create(CreatePessoaDTO dto) {
        Pessoa pessoa = mapper.createToEntity(dto);

        repository.save(pessoa);


    }
}
