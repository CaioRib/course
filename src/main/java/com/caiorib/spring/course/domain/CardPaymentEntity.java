package com.caiorib.spring.course.domain;

import com.caiorib.spring.course.domain.enums.PaymentStatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CARD_PAYMENT")
public class CardPaymentEntity extends PaymentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "NUM_INSTALLMENT")
    private Integer installments;

    public CardPaymentEntity() {
    }

    public CardPaymentEntity(Long id, PaymentStatusEnum paymentStatus, OrderEntity orderEntity, Integer installments) {
        super(id, paymentStatus, orderEntity);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
