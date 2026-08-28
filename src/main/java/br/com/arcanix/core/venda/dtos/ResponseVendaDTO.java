package br.com.arcanix.core.venda.dtos;

import br.com.arcanix.core.formaspagamento.entities.FormaPagamento;
import br.com.arcanix.core.pessoa.entities.Pessoa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record ResponseVendaDTO(Long id,
                               FormaPagamento formaPagamento,
                               Pessoa cliente,
                               LocalDate dataVenda,
                               LocalTime horaVenda,
                               List<ResponseVendaItemDTO> itens)
{ }
