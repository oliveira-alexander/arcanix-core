package br.com.arcanix.core.shared.exceptions.produto;

import br.com.arcanix.core.shared.exceptions.BusinessException;

public class ProdutoNotFoundException extends BusinessException {
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}
