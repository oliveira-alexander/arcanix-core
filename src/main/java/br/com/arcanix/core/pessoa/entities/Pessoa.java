package br.com.arcanix.core.pessoa.entities;

import br.com.arcanix.core.pessoa.entities.enums.TipoParceiro;
import br.com.arcanix.core.pessoa.entities.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pessoas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 100,
            nullable = false)
    private String razaoSocial;

    @Column(length = 100,
            nullable = false)
    private String nomeFantasia;

    @Column(length = 14)
    private String cpf;

    @Column(length = 18)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "pessoa",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<Telefone> telefones;

    @Enumerated
    private List<TipoParceiro> tipoParceiro;

    @Override
    public boolean equals(Object obj){
        Pessoa comparando = (Pessoa) obj;

        return (this.razaoSocial.equals(comparando.razaoSocial))
                && (this.nomeFantasia.equals(comparando.nomeFantasia))
                && (this.cpf.equals(comparando.cpf))
                && (this.cnpj.equals(comparando.cnpj));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.razaoSocial,
                this.nomeFantasia, this.cpf, this.cnpj);
    }
}
