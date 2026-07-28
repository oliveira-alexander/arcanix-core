package br.com.arcanix.core.produto.mapper;

import br.com.arcanix.core.produto.dtos.categoriaProduto.CreateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.categoriaProduto.UpdateCategoriaProdutoDTO;
import br.com.arcanix.core.produto.entities.CategoriaProduto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoriaProdutoMapper {

    // DTOs -> Entity

        CategoriaProduto createDtoToEntity(CreateCategoriaProdutoDTO dto);

        void updateDtoToEntity(UpdateCategoriaProdutoDTO dto,
                                           @MappingTarget
                                           CategoriaProduto entity);

    // Entity -> Response DTO

        ResponseCategoriaProdutoDTO entityToResponseDto(CategoriaProduto entity);
}
