package com.caiorib.spring.course.domain;

import com.caiorib.spring.course.domain.enums.PaymentStatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "PAYMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PaymentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_PAYMENT")
    private Long id;

    @Column(name = "COD_STATUS")
    private Long paymentStatus;

    @OneToOne
    @JoinColumn(name = "IDT_ORDER")
    private OrderEntity order;

    public PaymentEntity() {
    }

    public PaymentEntity(Long id, PaymentStatusEnum paymentStatus, OrderEntity order) {
        this.id = id;
        this.paymentStatus = paymentStatus.getId();
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentStatusEnum getPaymentStatus() {
        return PaymentStatusEnum.toEnum(this.paymentStatus);
    }

    public void setPaymentStatus(PaymentStatusEnum paymentStatus) {
        this.paymentStatus = paymentStatus.getId();
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
