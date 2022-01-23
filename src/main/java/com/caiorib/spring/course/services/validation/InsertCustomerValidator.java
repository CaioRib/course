package com.caiorib.spring.course.services.validation;

import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.domain.enums.CustomerTypeEnum;
import com.caiorib.spring.course.dto.request.CreateCustomerRequestBody;
import com.caiorib.spring.course.repositories.CustomerRepository;
import com.caiorib.spring.course.resources.handler.FieldMessage;
import com.caiorib.spring.course.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InsertCustomerValidator implements ConstraintValidator<InsertCustomer, CreateCustomerRequestBody> {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void initialize(InsertCustomer ann) {
    }

    @Override
    public boolean isValid(CreateCustomerRequestBody customerRequestBody, ConstraintValidatorContext context) {
        final List<FieldMessage> errors = new ArrayList<>();

        if(customerRequestBody.getType().equals(CustomerTypeEnum.NATURAL_PERSON.getId()) && !BR.isValidCPF(customerRequestBody.getLegalId())) {
            errors.add(new FieldMessage("legalId", "CPF invalido."));
        }

        else if (customerRequestBody.getType().equals(CustomerTypeEnum.LEGAL_ENTITY.getId()) && !BR.isValidCNPJ(customerRequestBody.getLegalId())) {
            errors.add(new FieldMessage("legalId", "CNPJ invalido."));
        }

        CustomerEntity customer = customerRepository.findByEmail(customerRequestBody.getEmail());
        if(Objects.nonNull(customer)) {
            errors.add(new FieldMessage("email", "Email ja registrado."));
        }

        for (FieldMessage e : errors) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getName()).addConstraintViolation();
        }
        return errors.isEmpty();
    }
}
