package br.com.arcanix.core.formaspagamento.services;

import br.com.arcanix.core.formaspagamento.dtos.CreateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.ResponseFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.UpdateFormaPagamentoDTO;

import java.util.List;

public interface FormaPagamentoService {

    ResponseFormaPagamentoDTO create(CreateFormaPagamentoDTO dto);
    ResponseFormaPagamentoDTO update(Long id, UpdateFormaPagamentoDTO dto);
    void delete(Long id);
    List<ResponseFormaPagamentoDTO> findAll();

}
