package com.justin.banco.advice;

import org.hibernate.sql.results.NoMoreOutputsException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail; 
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError; 
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

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

    @ExceptionHandler({MethodArgumentNotValidException.class,HttpMessageNotReadableException.class})
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

    // QueryTimeoutException - if the query execution exceeds the query timeout
    // value set and only the statement is rolled back
    // PersistenceException

    @ExceptionHandler({ NoMoreOutputsException.class, JpaSystemException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handlerNoMoreOutputsException(Exception ex) {
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        return problemDetail;

    }


    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleResponseStatusException(ResponseStatusException ex) {
        var problemDetail = ProblemDetail.forStatusAndDetail(ex.getStatusCode(), ex.getReason());

        return problemDetail;

    }
}
