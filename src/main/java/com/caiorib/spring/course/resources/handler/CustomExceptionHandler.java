package com.caiorib.spring.course.resources.handler;

import com.caiorib.spring.course.services.exceptions.DataIntegrityException;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException dataIntegrityException, HttpServletRequest httpServletRequest) {
        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), dataIntegrityException.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
        final ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation error", System.currentTimeMillis());
        methodArgumentNotValidException.getFieldErrors().forEach(error -> validationError.addError(new FieldMessage(error.getField(), error.getDefaultMessage())));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}
