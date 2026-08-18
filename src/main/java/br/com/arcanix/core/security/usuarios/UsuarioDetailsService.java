package br.com.arcanix.core.security.usuarios;

import br.com.arcanix.core.usuario.entities.Usuario;
import br.com.arcanix.core.usuario.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UsuarioDetails(usuario);
    }
}
