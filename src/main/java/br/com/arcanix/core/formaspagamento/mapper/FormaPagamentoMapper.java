package br.com.arcanix.core.formaspagamento.mapper;

import br.com.arcanix.core.formaspagamento.dtos.CreateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.ResponseFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.dtos.UpdateFormaPagamentoDTO;
import br.com.arcanix.core.formaspagamento.entities.FormaPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper {

    // DTOs -> Entity
        FormaPagamento createToEntity(CreateFormaPagamentoDTO dto);
        void updateToEntity(UpdateFormaPagamentoDTO dto,
                                      @MappingTarget FormaPagamento entity);

    // Entity -> Response DTO
        ResponseFormaPagamentoDTO entityToResponseDTO (FormaPagamento entity);
}
