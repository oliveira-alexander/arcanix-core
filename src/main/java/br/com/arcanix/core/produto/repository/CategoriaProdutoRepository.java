package br.com.arcanix.core.produto.repository;

import br.com.arcanix.core.produto.entities.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Long> {
    Optional<CategoriaProduto> findByDescricao(String descricao);
}
