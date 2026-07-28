package br.com.arcanix.core.produto.mapper;

import br.com.arcanix.core.produto.dtos.produto.CreateProdutoDTO;
import br.com.arcanix.core.produto.entities.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto createDtoToEntity(CreateProdutoDTO dto);


}
