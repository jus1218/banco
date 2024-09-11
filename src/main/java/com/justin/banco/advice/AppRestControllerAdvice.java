package com.justin.banco.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Order(Ordered.LOWEST_PRECEDENCE)
@RestControllerAdvice
public class AppRestControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handlerExceptionAll(Exception e) {

        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());

        problemDetail.setTitle("Ocurrio una excepcion");
        problemDetail.setType(URI.create("https://www.someurl.com/errors/bad-request"));

        // problemDetail.setProperty("Nombre", "Justin");

        return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        StringBuilder str = new StringBuilder();
        List<String> details = new ArrayList<String>();
        var errors = ex.getBindingResult().getAllErrors();

        for (var error : errors) {

            if (error instanceof FieldError) {
                str.setLength(0);

                FieldError fieldError = (FieldError) error;
                str.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage());
                details.add(str.toString());
            }

        }
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, details.toString());
        problemDetail.setTitle("Error en la validación de campos");
        problemDetail.setType(URI.create("https://www.someurl.com/errors/bad-request"));
        return problemDetail;
    }

}
