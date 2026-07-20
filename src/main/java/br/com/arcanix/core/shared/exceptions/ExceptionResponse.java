package br.com.arcanix.core.shared.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp,
        HttpStatus status,
        String message
)
{}
