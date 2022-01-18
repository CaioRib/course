package com.caiorib.spring.course.resources.handler;

import java.io.Serializable;
import java.util.Objects;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long timestamp;

    public StandardError() {
    }

    public StandardError(Integer status, String message, Long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
