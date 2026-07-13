package br.com.arcanix.core.pessoa.validators;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.validators.impl.PessoaEstrangeiraValidator;
import br.com.arcanix.core.pessoa.validators.impl.PessoaFisicaValidator;
import br.com.arcanix.core.pessoa.validators.impl.PessoaJuridicaValidator;

public class PessoaValidatorFactory {

    public PessoaValidatorFactory(Pessoa pessoa){
        getValidator(pessoa)
                .validar();
    }

    private PessoaValidator getValidator(Pessoa pessoa){
        switch(pessoa.getTipoPessoa()) {
            case PESSOA_FISICA -> { return new PessoaFisicaValidator(pessoa); }
            case PESSOA_JURIDICA -> { return new PessoaJuridicaValidator(pessoa); }
            default -> { return new PessoaEstrangeiraValidator(pessoa);}
        }
    }
}
