package com.caiorib.spring.course.resources.handler;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String message;

    public FieldMessage() {
    }

    public FieldMessage(String fieldName, String fieldMessage) {
        this.name = fieldName;
        this.message = fieldMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
