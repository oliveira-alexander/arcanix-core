package br.com.arcanix.core.venda.dtos;

import br.com.arcanix.core.produto.entities.Produto;

import java.math.BigDecimal;

public record ResponseVendaItemDTO(Long id,
                                   Produto produto,
                                   BigDecimal custoUnitario,
                                   BigDecimal precoUnitario,
                                   BigDecimal quantidade)
{  }
