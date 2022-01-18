package com.caiorib.spring.course.domain.enums;

import java.util.Arrays;
import java.util.Optional;

public enum PaymentStatusEnum {
    PENDING(1L, "Pendente"),
    FINISHED(2L, "Quitado"),
    CANCELED(3L, "Cancelado");

    private final Long id;
    private final String description;

    private PaymentStatusEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatusEnum toEnum(Long id) {
        final Optional<PaymentStatusEnum> customerType = Arrays.stream(PaymentStatusEnum.values())
                .filter(type -> type.getId().equals(id))
                .findFirst();

        return customerType.orElse(null);

    }
}
