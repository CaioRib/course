package com.caiorib.spring.course.domain;

import com.caiorib.spring.course.domain.db.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItemEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private OrderItemPK id;

    @Column(name = "NUM_DISCOUNT")
    private Double discount;

    @Column(name = "NUM_AMOUNT")
    private Integer amount;

    @Column(name = "NUM_PRICE")
    private Double price;

    public OrderItemEntity() {
        this.id = new OrderItemPK();
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, Double discount, Integer amount, Double price) {
        this.id = new OrderItemPK();
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.discount = discount;
        this.amount = amount;
        this.price = price;
    }

    @JsonIgnore
    public OrderEntity getOrder() {
        return this.id.getOrder();
    }

    public ProductEntity getProduct() {
        return this.id.getProduct();
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemEntity that = (OrderItemEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
