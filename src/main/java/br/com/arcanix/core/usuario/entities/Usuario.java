package br.com.arcanix.core.usuario.entities;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String email;

    @Column
    private String password;

    private boolean active;

    @OneToOne
    @JoinColumn(name = "pessoa_id",
        referencedColumnName = "id")
    private Pessoa pessoa;
}
