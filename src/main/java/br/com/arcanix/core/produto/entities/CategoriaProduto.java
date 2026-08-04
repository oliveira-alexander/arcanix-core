package br.com.arcanix.core.produto.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "produtos_categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String descricao;
}
