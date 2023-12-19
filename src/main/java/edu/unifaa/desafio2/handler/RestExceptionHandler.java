package edu.unifaa.desafio2.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.unifaa.desafio2.model.ErrorModel;
import edu.unifaa.desafio2.model.exceptions.ResourceNotFoundException;
import edu.unifaa.desafio2.model.exceptions.ResourceBadRequestException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException ex){
        ErrorModel error = new ErrorModel("Bad Request", ex.getMessage(),HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException ex){
        ErrorModel error = new ErrorModel("Not Found", ex.getMessage(),HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerResourceException(Exception ex){
        ErrorModel error = new ErrorModel("Internal Server Error", ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }
}
