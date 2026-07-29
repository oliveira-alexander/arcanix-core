package br.com.arcanix.core.produto.entities;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal custoUnitario;

    private BigDecimal valorUnitario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    CategoriaProduto categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Pessoa fornecedor;

    @Override
    public boolean equals(Object obj){
        Produto comparando = (Produto) obj;

        return (this.id == comparando.getId()) &&
               (this.descricao.equals(comparando.getDescricao())) &&
               (this.categoria.getId() == comparando.getCategoria().getId());
    }
}
