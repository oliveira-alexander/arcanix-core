package br.com.arcanix.core.produto.repository;

import br.com.arcanix.core.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
