package br.com.arcanix.core.pessoa.entities;

import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="pessoas")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String razaoSocial;
    private String nomeFantasia;
    private String cpf;
    private String cnpj;

    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones;



}
