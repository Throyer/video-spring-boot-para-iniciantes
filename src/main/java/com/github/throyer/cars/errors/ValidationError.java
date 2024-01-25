package com.github.throyer.cars.errors;

import lombok.Getter;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

@Getter
public class ValidationError {
    private final String field;
    private final String message;

    public ValidationError(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }

    public static List<ValidationError> of(MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
            .getAllErrors()
            .stream()
            .map((error) -> (new ValidationError((org.springframework.validation.FieldError) error)))
            .toList();
    }
}
