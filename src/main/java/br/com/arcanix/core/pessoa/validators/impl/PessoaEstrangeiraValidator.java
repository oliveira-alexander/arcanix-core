package br.com.arcanix.core.pessoa.validators.impl;

import br.com.arcanix.core.pessoa.entities.Pessoa;
import br.com.arcanix.core.pessoa.validators.PessoaValidator;

public class PessoaEstrangeiraValidator implements PessoaValidator {

    private final Pessoa pessoa;

    public PessoaEstrangeiraValidator(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    @Override
    public void validar() {

    }
}
