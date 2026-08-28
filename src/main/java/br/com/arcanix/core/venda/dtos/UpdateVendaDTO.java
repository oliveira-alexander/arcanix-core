package br.com.arcanix.core.venda.dtos;

import java.util.List;

public record UpdateVendaDTO(Long formaPagamentoId,
                             Long clienteId,
                             List<CreateVendaItemDTO> itens) {
}
