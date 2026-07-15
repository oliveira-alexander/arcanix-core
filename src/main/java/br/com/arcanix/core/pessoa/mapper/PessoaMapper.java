package br.com.arcanix.core.pessoa.mapper;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.ResponsePessoaDTO;
import br.com.arcanix.core.pessoa.dtos.UpdatePessoaDTO;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa createToEntity(CreatePessoaDTO dto);

    void updateToEntity(UpdatePessoaDTO dto,
                        @MappingTarget Pessoa pessoa);

    // Entity -> Response DTO
        ResponsePessoaDTO entityToResponse(Pessoa entity);

}
