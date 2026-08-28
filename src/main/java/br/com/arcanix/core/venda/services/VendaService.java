package br.com.arcanix.core.venda.services;

import br.com.arcanix.core.venda.dtos.CreateVendaDTO;
import br.com.arcanix.core.venda.dtos.ResponseVendaDTO;
import br.com.arcanix.core.venda.dtos.UpdateVendaDTO;

import java.util.List;

public interface VendaService {

    ResponseVendaDTO create(CreateVendaDTO dto);
    List<ResponseVendaDTO> findAll();
    void delete(Long id);
    ResponseVendaDTO update(Long id, UpdateVendaDTO dto);
}
