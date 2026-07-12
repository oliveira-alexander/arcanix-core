package br.com.arcanix.core.pessoa.repository;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
