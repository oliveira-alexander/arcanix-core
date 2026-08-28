package br.com.arcanix.core.venda.repositories;

import br.com.arcanix.core.venda.entities.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VendaItemRepository
    extends JpaRepository<VendaItem,Long> {
    Optional<List<VendaItem>> findByVendaId(Long vendaId);
}
