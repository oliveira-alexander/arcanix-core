package br.com.arcanix.core.produto.services.impl;

import br.com.arcanix.core.produto.dtos.categoriaProduto.CreateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.UpdateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.entities.CategoriaProduto;
import br.com.arcanix.core.produto.mapper.CategoriaProdutoMapper;
import br.com.arcanix.core.produto.repository.CategoriaProdutoRepository;
import br.com.arcanix.core.produto.services.CategoriaProdutoService;
import br.com.arcanix.core.shared.exceptions.categoriaProduto.CategoriaProdutoAlreadyExistsException;
import br.com.arcanix.core.shared.exceptions.categoriaProduto.CategoriaProdutoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaProdutoServiceImpl implements CategoriaProdutoService {

    private final CategoriaProdutoRepository repository;
    private final CategoriaProdutoMapper mapper;

    @Override
    public ResponseCategoriaProdutoDTO create(CreateCategoriaProdutoDTO dto) {
        if (repository.findByDescricao(dto.descricao()).isPresent())
            throw new CategoriaProdutoAlreadyExistsException("A categoria de produto já existe!");

        CategoriaProduto entity = mapper.createDtoToEntity(dto);

        repository.save(entity);

        return mapper.entityToResponseDto(entity);
    }

    @Override
    public List<ResponseCategoriaProdutoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::entityToResponseDto)
                .toList();
    }

    @Override
    public ResponseCategoriaProdutoDTO update(Long id, UpdateCategoriaProdutoDTO dto) {
        CategoriaProduto entity = repository.findById(id)
                .orElseThrow(
                        () -> new CategoriaProdutoNotFoundException("Categoria de produto não encontrda!"));

        mapper.updateDtoToEntity(dto, entity);

       repository.save(entity);

       return mapper.entityToResponseDto(entity);
    }

    @Override
    public void delete(Long id) {
        CategoriaProduto entity = repository.findById(id)
                .orElseThrow(
                        () -> new CategoriaProdutoNotFoundException("Categoria de produto não encontrda!"));

        repository.delete(entity);
    }
}
