package br.com.arcanix.core.venda.mapper;

import br.com.arcanix.core.venda.dtos.CreateVendaDTO;
import br.com.arcanix.core.venda.dtos.ResponseVendaDTO;
import br.com.arcanix.core.venda.dtos.ResponseVendaItemDTO;
import br.com.arcanix.core.venda.dtos.UpdateVendaDTO;
import br.com.arcanix.core.venda.entities.Venda;
import br.com.arcanix.core.venda.entities.VendaItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VendaMapper {

        ResponseVendaDTO toResponse(Venda venda);

        ResponseVendaItemDTO toResponseItem(VendaItem item);
}
