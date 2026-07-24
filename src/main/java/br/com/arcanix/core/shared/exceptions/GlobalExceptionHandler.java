package br.com.arcanix.core.shared.exceptions;

import br.com.arcanix.core.shared.exceptions.pessoa.PessoaNotFoundException;
import br.com.arcanix.core.shared.exceptions.validation.FieldErrorResponse;
import br.com.arcanix.core.shared.exceptions.validation.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<ExceptionResponse> pessoaNotFoundHandle(PessoaNotFoundException ex){
        ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> validationErrorHandle(MethodArgumentNotValidException ex)
    {
        List<FieldErrorResponse> errorsList = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new FieldErrorResponse(error.getField(),
                        error.getDefaultMessage()))
                .toList();

            ValidationErrorResponse response = new ValidationErrorResponse(
                    LocalDateTime.now(),
                    HttpStatus.BAD_REQUEST.value(),
                    "Erro de Validação",
                    errorsList
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ValidationErrorResponse> jsonParseHandle(HttpMessageNotReadableException ex){
        ValidationErrorResponse response = new ValidationErrorResponse(LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro na leitura do JSON",
                null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
