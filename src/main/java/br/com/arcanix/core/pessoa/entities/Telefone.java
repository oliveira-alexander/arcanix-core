package br.com.arcanix.core.pessoa.entities;

import br.com.arcanix.core.pessoa.entities.enums.TipoTelefone;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "telefones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoTelefone tipoTelefone;

    @Column(length = 20)
    private String numero;
}
