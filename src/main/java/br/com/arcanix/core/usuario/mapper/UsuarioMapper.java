package br.com.arcanix.core.usuario.mapper;

import br.com.arcanix.core.usuario.dtos.CreateUsuarioDTO;
import br.com.arcanix.core.usuario.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // DTOs -> Entity

        Usuario createToEntity(CreateUsuarioDTO dto);
}
