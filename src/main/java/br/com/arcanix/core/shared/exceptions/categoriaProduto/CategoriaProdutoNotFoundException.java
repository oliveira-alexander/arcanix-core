package br.com.arcanix.core.shared.exceptions.categoriaProduto;

import br.com.arcanix.core.shared.exceptions.BusinessException;

public class CategoriaProdutoNotFoundException extends BusinessException {
    public CategoriaProdutoNotFoundException(String message) {
        super(message);
    }
}
