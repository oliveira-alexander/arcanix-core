package br.com.arcanix.core.usuario.repositories;

import br.com.arcanix.core.usuario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
}
