package com.caiorib.spring.course.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BUYING_ORDER")
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_ORDER")
    private Long id;

    @Column(name = "DAT_ORDER")
    private Date date;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name="IDT_CUSTOMER", foreignKey = @ForeignKey(name = "CUSTOMER_FK"))
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name="IDT_ADDRESS", foreignKey = @ForeignKey(name = "ADDRESS_FK"))
    private AddressEntity deliveryAddress;

    public OrderEntity() {
    }

    public OrderEntity(Long id, Date date, CustomerEntity customer, AddressEntity deliveryAddress) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.deliveryAddress = deliveryAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public AddressEntity getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressEntity deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
