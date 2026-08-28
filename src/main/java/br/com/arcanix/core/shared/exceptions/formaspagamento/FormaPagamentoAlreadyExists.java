package br.com.arcanix.core.shared.exceptions.formaspagamento;

public class FormaPagamentoAlreadyExists extends RuntimeException {
    public FormaPagamentoAlreadyExists(String message) {
        super(message);
    }
}
