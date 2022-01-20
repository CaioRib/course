package com.caiorib.spring.course.dto.response;

import com.caiorib.spring.course.domain.CustomerEntity;

import java.io.Serializable;

public class CustomerResponseBody implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;

    public CustomerResponseBody() {
    }

    public CustomerResponseBody(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerEntity toCustomerEntity(){
        return new CustomerEntity(null, name, email, null, null);
    }
}
