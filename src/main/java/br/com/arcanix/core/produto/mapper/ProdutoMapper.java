package br.com.arcanix.core.produto.mapper;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.produto.dtos.categoriaProduto.ResponseCategoriaProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.CreateProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.ResponseFornecedorDTO;
import br.com.arcanix.core.produto.dtos.produto.ResponseProdutoDTO;
import br.com.arcanix.core.produto.dtos.produto.UpdateProdutoDTO;
import br.com.arcanix.core.produto.entities.CategoriaProduto;
import br.com.arcanix.core.produto.entities.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // DTOs -> Entity
        Produto createDtoToEntity(CreateProdutoDTO dto);

        void updateDtoToEntity(UpdateProdutoDTO dto,
                               @MappingTarget Produto entity);

    // Responses
        ResponseCategoriaProdutoDTO categoriaProdutoToResponse(CategoriaProduto entity);

        ResponseFornecedorDTO pessoaToFornecedorResponse(Pessoa entity);

    // Entity -> Response DTO

        @Mapping(target = "id", source = "produto.id")
        @Mapping(target = "descricao", source = "produto.descricao")
        @Mapping(target = "categoria", source = "categoria")
        @Mapping(target = "fornecedor", source = "fornecedor")
        ResponseProdutoDTO entityToResponseDto(ResponseCategoriaProdutoDTO categoria,
                                               ResponseFornecedorDTO fornecedor,
                                                Produto produto);
}
