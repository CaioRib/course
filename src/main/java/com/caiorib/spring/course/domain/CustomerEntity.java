package com.caiorib.spring.course.domain;

import com.caiorib.spring.course.domain.enums.CustomerTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_CUSTOMER")
    private Long id;

    @Column(name = "NAM_CUSTOMER")
    private String name;

    @Column(name = "NAM_EMAIL")
    private String email;

    @Column(name = "COD_LEGAL_ID")
    private String legalId;

    @Column(name = "COD_TYPE")
    private Long type;

    @OneToMany(mappedBy = "customer")
    private List<AddressEntity> addresses;

    @ElementCollection
    @CollectionTable(name = "PHONE", joinColumns = @JoinColumn(name="IDT_CUSTOMER", referencedColumnName = "IDT_CUSTOMER"))
    private Set<String> phones;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<OrderEntity> orders;

    public CustomerEntity() {
        this.addresses = new ArrayList<>();
        this.phones = new HashSet<>();
        this.orders = new ArrayList<>();
    }

    public CustomerEntity(Long id, String name, String email, String legalId, CustomerTypeEnum type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.legalId = legalId;
        this.type = (Objects.isNull(type)) ? null : type.getId();
        this.addresses = new ArrayList<>();
        this.phones = new HashSet<>();
        this.orders = new ArrayList<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }

    public CustomerTypeEnum getType() {
        return CustomerTypeEnum.toEnum(this.type);
    }

    public void setType(CustomerTypeEnum type) {
        this.type = type.getId();
    }

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
