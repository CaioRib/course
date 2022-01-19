package com.caiorib.spring.course.services.exceptions;

public class DataIntegrityException extends RuntimeException {

    public DataIntegrityException(String message) {
        super(message);
    }

    public DataIntegrityException(String message, Throwable cause){
        super(message, cause);
    }


}
