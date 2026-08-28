package br.com.arcanix.core.formaspagamento.repositories;

import br.com.arcanix.core.formaspagamento.entities.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormaPagamentoRepository
    extends JpaRepository<FormaPagamento, Long> {

    Optional<FormaPagamento> findByDescricao(String descricao);

}
