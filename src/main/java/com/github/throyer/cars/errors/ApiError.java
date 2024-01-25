package com.github.throyer.cars.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
public class ApiError {
    private final String message;
    private final Integer status;

    @JsonInclude(NON_NULL)
    private final Collection<ValidationError> errors;

    public ApiError(HttpStatusCode status, Collection<ValidationError> errors) {
        this.message = "Check the 'errors' property for more details.";
        this.status = status.value();
        this.errors = errors;
    }

    public ApiError(String message, HttpStatusCode status) {
        this.message = message;
        this.status = status.value();
        this.errors = null;
    }
}
