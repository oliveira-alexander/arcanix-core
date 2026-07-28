package br.com.arcanix.core.shared.exceptions.categoriaProduto;

import br.com.arcanix.core.shared.exceptions.BusinessException;

public class CategoriaProdutoAlreadyExistsException extends BusinessException {
    public CategoriaProdutoAlreadyExistsException(String message) {
        super(message);
    }
}
