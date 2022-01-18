package com.caiorib.spring.course.domain;

import com.caiorib.spring.course.domain.enums.PaymentStatusEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SLIP_PAYMENT")
public class SlipPaymentEntity extends PaymentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "DAT_DEADLINE")
    private Date deadline;

    @Column(name = "DAT_PAYMENT")
    private Date datePayment;

    public SlipPaymentEntity() {
    }

    public SlipPaymentEntity(Long id, PaymentStatusEnum paymentStatus, OrderEntity orderEntity, Date deadline, Date datePayment) {
        super(id, paymentStatus, orderEntity);
        this.datePayment = datePayment;
        this.deadline = deadline;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }


}
