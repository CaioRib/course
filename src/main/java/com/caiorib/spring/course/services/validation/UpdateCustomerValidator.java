package com.caiorib.spring.course.services.validation;

import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.domain.enums.CustomerTypeEnum;
import com.caiorib.spring.course.dto.request.CreateCustomerRequestBody;
import com.caiorib.spring.course.dto.request.CustomerRequestBody;
import com.caiorib.spring.course.repositories.CustomerRepository;
import com.caiorib.spring.course.resources.handler.FieldMessage;
import com.caiorib.spring.course.services.validation.util.BR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UpdateCustomerValidator implements ConstraintValidator<UpdateCustomer, CustomerRequestBody> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void initialize(UpdateCustomer ann) {
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(CustomerRequestBody customerRequestBody, ConstraintValidatorContext context) {
        Map<String, String> attributes = (Map<String, String>) httpServletRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Long uriId = Long.parseLong(attributes.get("id"));

        final List<FieldMessage> errors = new ArrayList<>();

        CustomerEntity customer = customerRepository.findByEmail(customerRequestBody.getEmail());
        if(Objects.nonNull(customer) && !customer.getId().equals(uriId)) {
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
