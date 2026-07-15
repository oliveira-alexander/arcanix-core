package br.com.arcanix.core.pessoa.services.impl;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.ResponsePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.UpdatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.UpdateTelefoneDTO;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.entities.Telefone;
import br.com.arcanix.core.pessoa.mapper.PessoaMapper;
import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.pessoa.services.PessoaService;
import br.com.arcanix.core.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;
    private final PessoaMapper mapper;

    @Override
    public ResponsePessoaDTO create(CreatePessoaDTO dto) {
        Pessoa pessoa = mapper.createToEntity(dto);

        if (pessoa.getTelefones() != null)
            pessoa.getTelefones()
                    .forEach(telefone -> telefone.setPessoa(pessoa));

        repository.save(pessoa);
        return mapper.entityToResponse(pessoa);
    }

    @Override
    public ResponsePessoaDTO update(Long id, UpdatePessoaDTO dto) {
        Pessoa pessoa = repository.findById(id)
                .orElseThrow(() -> new BusinessException("Pessoa não encontrada!"));

        mapper.updateToEntity(dto, pessoa);

        if (dto.telefones() != null)
            atualizarTelefones(dto.telefones(), pessoa);

        repository.save(pessoa);

        return mapper.entityToResponse(pessoa);
    }

    @Override
    public void delete(Long id) {
        Pessoa pessoa = repository.findById(id)
                        .orElseThrow(() -> new BusinessException("Pessoa não encontrada!"));

        repository.delete(pessoa);
    }

    @Override
    public List<ResponsePessoaDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::entityToResponse)
                .toList();
    }

    private void atualizarTelefones(List<UpdateTelefoneDTO> telefones,
                                    Pessoa pessoa){

        pessoa.getTelefones().clear();

        telefones.forEach(telefoneDTO -> {
            Telefone telefone = Telefone.builder()
                    .id(telefoneDTO.id())
                    .tipoTelefone(telefoneDTO.tipoTelefone())
                    .pessoa(pessoa)
                    .numero(telefoneDTO.numero())
                    .build();

            pessoa.getTelefones().add(telefone);

        });
    }
}
