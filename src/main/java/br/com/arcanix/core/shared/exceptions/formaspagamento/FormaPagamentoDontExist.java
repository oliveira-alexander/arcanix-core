package br.com.arcanix.core.shared.exceptions.formaspagamento;

public class FormaPagamentoDontExist extends RuntimeException {
    public FormaPagamentoDontExist(String message) {
        super(message);
    }
}
