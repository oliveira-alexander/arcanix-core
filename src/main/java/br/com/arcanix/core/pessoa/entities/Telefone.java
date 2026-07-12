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

    @ManyToOne
    private Pessoa pessoa;

    private TipoTelefone tipoTelefone;
    private String telefone;
}
