package br.com.arcanix.core.shared.exceptions.pessoa;

import br.com.arcanix.core.shared.exceptions.BusinessException;

public class PessoaNotFoundException extends BusinessException {
    public PessoaNotFoundException(String message) {
        super(message);
    }
}
