package com.caiorib.spring.course.dto.request;

import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.services.validation.UpdateCustomer;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@UpdateCustomer
public class CustomerRequestBody implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome é obrigatório.")
    @Length(min=5, max=120, message = "Nome com tamanho entre {min} e {max}")
    private String name;

    @NotEmpty(message = "E-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    public CustomerRequestBody() {
    }

    public CustomerRequestBody(String name, String email) {
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
