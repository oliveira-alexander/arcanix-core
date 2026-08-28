package br.com.arcanix.core.venda.dtos;

import java.math.BigDecimal;

public record UpdateVendaItemDTO(Long produtoId,
                                 BigDecimal custoUnitario,
                                 BigDecimal precoUnitario,
                                 BigDecimal quantidade) {
}
