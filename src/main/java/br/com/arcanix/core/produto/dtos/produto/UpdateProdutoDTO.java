package br.com.arcanix.core.produto.dtos.produto;

import java.math.BigDecimal;

public record UpdateProdutoDTO(String descricao,
                               BigDecimal custoUnitario,
                               BigDecimal valorUnitario,
                               Long categoriaId,
                               Long fornecedorId) {
}
