package br.com.arcanix.core.venda.repositories;

import br.com.arcanix.core.venda.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository
    extends JpaRepository<Venda, Long> {
}
