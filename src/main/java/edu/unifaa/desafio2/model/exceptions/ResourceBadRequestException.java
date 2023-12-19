package edu.unifaa.desafio2.model.exceptions;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String message){
        super(message);
    }
}
