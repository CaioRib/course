package com.caiorib.spring.course.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = InsertCustomerValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InsertCustomer {
    String message() default "Erro na validacao";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
