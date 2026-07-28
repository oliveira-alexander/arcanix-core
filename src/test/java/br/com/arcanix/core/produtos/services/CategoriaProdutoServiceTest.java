package br.com.arcanix.core.produtos.services;

import br.com.arcanix.core.produto.dtos.categoriaProduto.CreateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.UpdateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.entities.CategoriaProduto;
import br.com.arcanix.core.produto.mapper.CategoriaProdutoMapper;
import br.com.arcanix.core.produto.repository.CategoriaProdutoRepository;
import br.com.arcanix.core.produto.services.impl.CategoriaProdutoServiceImpl;
import br.com.arcanix.core.shared.exceptions.categoriaProduto.CategoriaProdutoAlreadyExistsException;
import br.com.arcanix.core.shared.exceptions.categoriaProduto.CategoriaProdutoNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoriaProdutoServiceTest {

    @Mock
    private CategoriaProdutoMapper mapper;

    @Mock
    private CategoriaProdutoRepository repository;

    @InjectMocks
    private CategoriaProdutoServiceImpl service;

    @Test
    void shouldThrowCategoriaProdutoAlreadyExistsExceptionOnCreate(){
        // Arrange
            Long id = 1L;

            CreateCategoriaProdutoDTO createDto = new CreateCategoriaProdutoDTO("Descrição");

            CategoriaProduto entity = CategoriaProduto.builder()
                    .id(1L)
                    .descricao("Descrição")
                    .build();

            when(repository.findByDescricao(createDto.descricao()))
                    .thenReturn(Optional.ofNullable(entity));

        // Act + Assert
            Assertions.assertThrows(CategoriaProdutoAlreadyExistsException.class,
                    () -> {service.create(createDto);});

    }

    @Test
    void shouldThrowCategoriaProdutoNotFoundExceptionOnUpdate(){
        // Arrange
            Long id = 2L;

            UpdateCategoriaProdutoDTO updateDto = new UpdateCategoriaProdutoDTO("Descrição");

            CategoriaProduto entity = CategoriaProduto.builder()
                    .id(1L)
                    .descricao("Descrição")
                    .build();

            when(repository.findById(2L))
                    .thenReturn(Optional.empty());

        // Act + Assert
            Assertions.assertThrows(CategoriaProdutoNotFoundException.class,
                    () -> {service.update(id, updateDto);});

    }

    @Test
    void shouldThrowCategoriaProdutoNotFoundExceptionOnDelete(){
        // Arrange
            Long id = 1L;

            when(repository.findById(1L))
                    .thenReturn(Optional.empty());

        // Act + Assert
            Assertions.assertThrows(CategoriaProdutoNotFoundException.class,
                    () -> {service.delete(id);});
    }


}
