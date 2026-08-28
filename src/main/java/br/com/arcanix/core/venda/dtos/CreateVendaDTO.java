package br.com.arcanix.core.venda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record CreateVendaDTO(Long formaPagamentoId,
                             Long clienteId,
                             List<CreateVendaItemDTO> itens) {
}
