package br.com.arcanix.core.produto.dtos.produto;

import java.math.BigDecimal;

public record CreateProdutoDTO(String descricao,
                               BigDecimal custoUnitario,
                               BigDecimal valorUnitario,
                               int categoriaId,
                               int fornecedorId) {
}
