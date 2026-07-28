package br.com.arcanix.core.produto.services.impl;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.CreateProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.ResponseFornecedorDTO;
import br.com.arcanix.core.produto.dtos.produto.ResponseProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.UpdateProdutoDTO;
import br.com.arcanix.core.produto.entities.CategoriaProduto;
import br.com.arcanix.core.produto.entities.Produto;
import br.com.arcanix.core.produto.mapper.ProdutoMapper;
import br.com.arcanix.core.produto.repository.CategoriaProdutoRepository;
import br.com.arcanix.core.produto.repository.ProdutoRepository;
import br.com.arcanix.core.produto.services.ProdutoService;
import br.com.arcanix.core.shared.exceptions.categoriaProduto.CategoriaProdutoNotFoundException;
import br.com.arcanix.core.shared.exceptions.pessoa.PessoaNotFoundException;
import br.com.arcanix.core.shared.exceptions.produto.ProdutoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoMapper mapper;
    private final ProdutoRepository produtoRepository;
    private final CategoriaProdutoRepository categoriaRepository;
    private final PessoaRepository pessoaRepository;


    @Override
    public ResponseProdutoDTO create(CreateProdutoDTO dto) {
        Produto entity = mapper.createDtoToEntity(dto);

        CategoriaProduto categoria = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new CategoriaProdutoNotFoundException("Categoria de Produto não encontrada!"));

        Pessoa fornecedor = pessoaRepository.findById(dto.fornecedorId())
                        .orElseThrow(() -> new PessoaNotFoundException("Fornecedor não encontrado!"));

        entity.setCategoria(categoria);
        entity.setFornecedor(fornecedor);

        produtoRepository.save(entity);

        return mapper.entityToResponseDto(
                mapper.categoriaProdutoToResponse(categoria),
                mapper.pessoaToFornecedorResponse(fornecedor),
                entity);
    }

    @Override
    public ResponseProdutoDTO update(Long id, UpdateProdutoDTO dto) {
        Produto entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado!"));

        mapper.updateDtoToEntity(dto, entity);

        CategoriaProduto categoria = categoriaRepository.findById(dto.categoriaId()).get();
        Pessoa fornecedor = pessoaRepository.findById(dto.fornecedorId()).get();

        entity.setCategoria(categoria);
        entity.setFornecedor(fornecedor);

        produtoRepository.save(entity);

        return mapper.entityToResponseDto(
                mapper.categoriaProdutoToResponse(categoria),
                mapper.pessoaToFornecedorResponse(fornecedor),
                entity);
    }

    @Override
    public List<ResponseProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(p -> {

                    ResponseCategoriaProdutoDTO responseCategoria = mapper.categoriaProdutoToResponse(p.getCategoria());
                    ResponseFornecedorDTO fornecedor = mapper.pessoaToFornecedorResponse(p.getFornecedor());

                    return mapper.entityToResponseDto(responseCategoria, fornecedor, p);
                })
                .toList();


    }

    @Override
    public void delete(Long id) {
        Produto entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado!"));

        produtoRepository.delete(entity);
    }
}
