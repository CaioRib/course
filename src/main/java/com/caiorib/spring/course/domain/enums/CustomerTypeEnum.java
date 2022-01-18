package com.caiorib.spring.course.domain.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CustomerTypeEnum {
    NATURAL_PERSON(1L, "Pessoa Física"),
    LEGAL_ENTITY(2L, "Pessoa Jurídica");

    private final Long id;
    private final String description;

    private CustomerTypeEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerTypeEnum toEnum(Long id) {
        final Optional<CustomerTypeEnum> customerType = Arrays.stream(CustomerTypeEnum.values())
                .filter(type -> type.getId().equals(id))
                .findFirst();

        return customerType.orElse(null);

    }
}
