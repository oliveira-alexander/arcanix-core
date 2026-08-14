package br.com.arcanix.core.produtos.services;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.entities.enums.TipoParceiro;
import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;
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
import br.com.arcanix.core.produto.services.impl.ProdutoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private CategoriaProdutoRepository categoriaRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private ProdutoMapper mapper;

    @InjectMocks
    private ProdutoServiceImpl service;

    @Test
    void shouldCreateProduto(){
        // Arrange
            Pessoa fornecedorEntity = new Pessoa(1L,
                    "Fornecedor A",
                    "Fornecedor A",
                    null,
                    "12.345.678/0001-00",
                    TipoPessoa.PESSOA_JURIDICA,
                    null,
                    List.of(TipoParceiro.CLIENTE));

            CategoriaProduto categoriaEntity = new CategoriaProduto(1l,
                    "Categoria A");

            CreateProdutoDTO produtoCreateDTO = new CreateProdutoDTO("Produto A",
                    new BigDecimal("1"),
                    new BigDecimal("1.5"),
                    1L,
                    1L);

            Produto produtoEntity = Produto.builder()
                    .id(1L)
                    .descricao("Produto A")
                    .custoUnitario(new BigDecimal("1"))
                    .valorUnitario(new BigDecimal("1.5"))
                    .categoria(categoriaEntity)
                    .fornecedor(fornecedorEntity)
                    .build();

            when(mapper.createDtoToEntity(produtoCreateDTO))
                    .thenReturn(produtoEntity);

            when(categoriaRepository.findById(1L))
                    .thenReturn(Optional.of(categoriaEntity));

            when(pessoaRepository.findById(1L))
                    .thenReturn(Optional.of(fornecedorEntity));

            when(produtoRepository.save(produtoEntity))
                    .thenReturn(produtoEntity);

            ResponseCategoriaProdutoDTO categoriaResponseDTO = new ResponseCategoriaProdutoDTO(1L, "Categoria A");

            ResponseFornecedorDTO fornecedorResponseDTO = new ResponseFornecedorDTO(1L, "Fornecedor A",
                    "Fornecedor A",
                    "12.345.678/0001-00");

            ResponseProdutoDTO produtoResponseDTO = new ResponseProdutoDTO(1L,
                    "Produto A",
                    new BigDecimal("1"),
                    new BigDecimal("1.5"),
                    categoriaResponseDTO,
                    fornecedorResponseDTO);

            when(mapper.categoriaProdutoToResponse(categoriaEntity))
                    .thenReturn(categoriaResponseDTO);

            when(mapper.pessoaToFornecedorResponse(fornecedorEntity))
                    .thenReturn(fornecedorResponseDTO);

            when(mapper.entityToResponseDto(categoriaResponseDTO, fornecedorResponseDTO, produtoEntity))
                    .thenReturn(produtoResponseDTO);

        // Act
            ResponseProdutoDTO response = service.create(produtoCreateDTO);

        // Assert
            Assertions.assertEquals(response, produtoResponseDTO);
    }

    @Test
    void shouldUpdateProduto(){
        // Arrange
            long id = 1L;

            Pessoa fornecedorEntity = new Pessoa(1L,
                    "Fornecedor A",
                    "Fornecedor A",
                    null,
                    "12.345.678/0001-00",
                    TipoPessoa.PESSOA_JURIDICA,
                    null,
                    List.of(TipoParceiro.CLIENTE));

            CategoriaProduto categoriaEntity = new CategoriaProduto(1L, "Categoria A");

            Produto produtoEntity = Produto.builder()
                    .id(1L)
                    .descricao("Produto A")
                    .custoUnitario(new BigDecimal("1"))
                    .valorUnitario(new BigDecimal("1.5"))
                    .categoria(categoriaEntity)
                    .fornecedor(fornecedorEntity)
                    .build();

            Produto produtoUpdtedEntity = Produto.builder()
                .id(1L)
                .descricao("Produto AB")
                .custoUnitario(new BigDecimal("1.2"))
                .valorUnitario(new BigDecimal("5"))
                .categoria(categoriaEntity)
                .fornecedor(fornecedorEntity)
                .build();

            UpdateProdutoDTO updateProduto = new UpdateProdutoDTO("Produto A",
                    new BigDecimal("1"),
                    new BigDecimal("1.5"),
                    1L,
                    1L);

            ResponseCategoriaProdutoDTO categoriaResponseDTO = new ResponseCategoriaProdutoDTO(1L, "Categoria A");

            ResponseFornecedorDTO fornecedorResponseDTO = new ResponseFornecedorDTO(1L, "Fornecedor A",
                    "Fornecedor A",
                    "12.345.678/0001-00");

            ResponseProdutoDTO produtoResponseDTO = new ResponseProdutoDTO(1L,
                    "Produto AB",
                    new BigDecimal("1.2"),
                    new BigDecimal("5"),
                    categoriaResponseDTO,
                    fornecedorResponseDTO);

            when(produtoRepository.findById(id))
                    .thenReturn(Optional.of(produtoEntity));

            when(categoriaRepository.findById(1L))
                    .thenReturn(Optional.of(categoriaEntity));

            when(pessoaRepository.findById(1L))
                    .thenReturn(Optional.of(fornecedorEntity));

            when( mapper.categoriaProdutoToResponse(categoriaEntity))
                    .thenReturn(categoriaResponseDTO);

            when(mapper.pessoaToFornecedorResponse(fornecedorEntity))
                    .thenReturn(fornecedorResponseDTO);

            when(mapper.entityToResponseDto(categoriaResponseDTO, fornecedorResponseDTO, produtoEntity))
                    .thenReturn(produtoResponseDTO);

        //Act
            ResponseProdutoDTO responseUpdated = service.update(id, updateProduto);

        // Assert
            Assertions.assertEquals(responseUpdated, produtoResponseDTO);
    }

    @Test
    void shouldDeleteProduto(){
        // Arrange
            Long id = 1L;

            Pessoa fornecedorEntity = new Pessoa(1L,
                    "Fornecedor A",
                    "Fornecedor A",
                    null,
                    "12.345.678/0001-00",
                    TipoPessoa.PESSOA_JURIDICA,
                    null,
                    List.of(TipoParceiro.CLIENTE));

            CategoriaProduto categoriaEntity = new CategoriaProduto(1L, "Categoria A");

            Produto produtoEntity = Produto.builder()
                    .id(1L)
                    .descricao("Produto A")
                    .custoUnitario(new BigDecimal("1"))
                    .valorUnitario(new BigDecimal("1.5"))
                    .categoria(categoriaEntity)
                    .fornecedor(fornecedorEntity)
                    .build();


            when(produtoRepository.findById(1L))
                    .thenReturn(Optional.of(produtoEntity));

        // Act
            service.delete(id);

        // Assert
        verify(produtoRepository).findById(id);
        verify(produtoRepository).delete(produtoEntity);
    }

}
