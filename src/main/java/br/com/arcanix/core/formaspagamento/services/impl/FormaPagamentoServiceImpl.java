package br.com.arcanix.core.formaspagamento.services.impl;

import br.com.arcanix.core.formaspagamento.dtos.CreateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.ResponseFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.UpdateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.entities.FormaPagamento;
import br.com.arcanix.core.formaspagamento.mapper.FormaPagamentoMapper;
import br.com.arcanix.core.formaspagamento.repositories.FormaPagamentoRepository;
import br.com.arcanix.core.formaspagamento.services.FormaPagamentoService;
import br.com.arcanix.core.shared.exceptions.formaspagamento.FormaPagamentoAlreadyExists;
import br.com.arcanix.core.shared.exceptions.formaspagamento.FormaPagamentoDontExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormaPagamentoServiceImpl
    implements FormaPagamentoService {

    private final FormaPagamentoRepository repository;
    private final FormaPagamentoMapper mapper;

    @Override
    public ResponseFormaPagamentoDTO create(CreateFormaPagamentoDTO dto) {
        FormaPagamento entity = mapper.createToEntity(dto);

        if (repository.findByDescricao(entity.getDescricao()).isPresent())
            throw new FormaPagamentoAlreadyExists("A Forma de Pagamento já existe!");

        repository.save(entity);

        return mapper.entityToResponseDTO(entity);
    }

    @Override
    public ResponseFormaPagamentoDTO update(Long id, UpdateFormaPagamentoDTO dto) {
        FormaPagamento entity = repository.findById(id)
                .orElseThrow(() -> new FormaPagamentoDontExist("A Forma de Pagamento não existe!"));

        mapper.updateToEntity(dto, entity);

        repository.save(entity);

        return mapper.entityToResponseDTO(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new FormaPagamentoDontExist("A Forma de Pagamento não existe!"));

        repository.deleteById(id);
    }

    @Override
    public List<ResponseFormaPagamentoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponseDTO)
                .toList();
    }
}
