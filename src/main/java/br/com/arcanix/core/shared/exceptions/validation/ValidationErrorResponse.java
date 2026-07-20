package br.com.arcanix.core.shared.exceptions.validation;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        LocalDateTime timestamp,
        int status,
        String message,
        List<FieldErrorResponse> errorsList
) {
}
