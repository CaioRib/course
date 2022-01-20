package com.caiorib.spring.course.resources.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> fieldMessages;

    public ValidationError() {
        fieldMessages = new ArrayList<>();
    }

    public ValidationError(Integer status, String message, Long timestamp) {
        super(status, message, timestamp);
        fieldMessages = new ArrayList<>();
    }

    public void addError(FieldMessage fieldMessage) {
        this.fieldMessages.add(fieldMessage);
    }

    public List<FieldMessage> getFieldMessages() {
        return fieldMessages;
    }
}
