package br.com.arcanix.core.formaspagamento.dtos;

import java.math.BigDecimal;

public record CreateFormaPagamentoDTO(String descricao,
                                      int qtdDiasRecebimento,
                                      BigDecimal taxaPercentual) {
}
