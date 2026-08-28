package br.com.arcanix.core.venda.entities;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.produto.entities.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "venda_itens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private BigDecimal custoUnitario;

    private BigDecimal precoUnitario;

    private BigDecimal quantidade;

    public BigDecimal getTotalCusto(){
        var totalCusto = this.quantidade.floatValue() * this.custoUnitario.floatValue();
        return BigDecimal.valueOf(totalCusto);
    }

    public BigDecimal getTotalPreco(){
        var totalPreco = this.quantidade.floatValue() * this.precoUnitario.floatValue();
        return BigDecimal.valueOf(totalPreco);
    }

    @Override
    public boolean equals(Object obj){
        VendaItem comparando = (VendaItem) obj;

        return (this.id == comparando.getId()) &&
                (this.produto.getId() == comparando.produto.getId());
    }
}
