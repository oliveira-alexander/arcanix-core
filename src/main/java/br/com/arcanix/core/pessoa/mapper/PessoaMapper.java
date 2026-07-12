package br.com.arcanix.core.pessoa.mapper;

import br.com.arcanix.core.pessoa.dtos.CreatePessoaDTO;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa createToEntity(CreatePessoaDTO dto);
}
