package br.com.arcanix.core.pessoa.validators.impl;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.validators.PessoaValidator;

public class PessoaJuridicaValidator implements PessoaValidator {

    private final Pessoa pessoa;

    public PessoaJuridicaValidator(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    @Override
    public void validar() {

    }
}
