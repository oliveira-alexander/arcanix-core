package br.com.arcanix.core.produtos.services;

import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.produto.mapper.ProdutoMapper;
import br.com.arcanix.core.produto.repository.CategoriaProdutoRepository;
import br.com.arcanix.core.produto.repository.ProdutoRepository;
import br.com.arcanix.core.produto.services.impl.ProdutoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

}
