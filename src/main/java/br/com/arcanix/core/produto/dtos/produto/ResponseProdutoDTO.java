package br.com.arcanix.core.produto.dtos.produto;

import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;

import java.math.BigDecimal;

public record ResponseProdutoDTO(Long id,
                                 String descricao,
                                 BigDecimal custoUnitario,
                                 BigDecimal valorUnitario,
                                 ResponseCategoriaProdutoDTO categoria,
                                 ResponseFornecedorDTO fornecedor) {
}
