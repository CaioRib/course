package com.caiorib.spring.course.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(Long id) {
        super("Object with id " + id + " not found");
    }

    public ObjectNotFoundException(String message, Throwable cause){
        super(message, cause);
    }


}
