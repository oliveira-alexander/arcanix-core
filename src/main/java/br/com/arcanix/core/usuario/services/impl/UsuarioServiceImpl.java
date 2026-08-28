package br.com.arcanix.core.usuario.services.impl;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.repository.PessoaRepository;
import br.com.arcanix.core.usuario.dtos.CreateUsuarioDTO;
import br.com.arcanix.core.usuario.entities.Usuario;
import br.com.arcanix.core.usuario.mapper.UsuarioMapper;
import br.com.arcanix.core.usuario.repositories.UsuarioRepository;
import br.com.arcanix.core.usuario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl
    implements UsuarioService {

    private final PessoaRepository pessoaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;

    @Override
    public String create(CreateUsuarioDTO dto) {
        Usuario usuario = mapper.createToEntity(dto);

        String encodedPassword = passwordEncoder.encode(dto.password());

        usuario.setActive(true);
        usuario.setPassword(encodedPassword);
        usuario.setPessoaId(-1L);

        usuarioRepository.save(usuario);

        return "Usuário criado com sucesso!";
    }
}
