package br.com.arcanix.core.shared.exceptions.validation;

public record FieldErrorResponse(
        String field,
        String message
) {
}
