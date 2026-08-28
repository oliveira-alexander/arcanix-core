package br.com.arcanix.core.venda.entities;

import br.com.arcanix.core.formaspagamento.entities.FormaPagamento;
import br.com.arcanix.core.pessoa.entities.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "vendas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id")
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Pessoa cliente;

    private LocalDate dataVenda;

    private LocalTime horaVenda;

    @OneToMany(mappedBy = "venda",
               cascade = CascadeType.REMOVE)
    private List<VendaItem> itens;
}
