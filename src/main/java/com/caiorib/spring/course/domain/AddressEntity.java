package com.caiorib.spring.course.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDT_ADDRESS")
    private Long id;

    @Column(name = "NAM_PLACE")
    private String place;

    @Column(name = "COD_NUMBER")
    private Long number;

    @Column(name = "DES_ADDITIONAL_INFO")
    private String additionalInfo;

    @Column(name = "NAM_DISTRICT")
    private String district;

    @Column(name = "COD_POSTA_CODE")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "IDT_CUSTOMER", foreignKey = @ForeignKey(name = "CUSTOMER_FK"))
    @JsonIgnore
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "IDT_CITY", foreignKey = @ForeignKey(name = "CITY_FK"))
    private CityEntity city;

    public AddressEntity() {
    }

    public AddressEntity(Long id, String place, Long number, String additionalInfo, String district, String postalCode, CustomerEntity customer, CityEntity city) {
        this.id = id;
        this.place = place;
        this.number = number;
        this.additionalInfo = additionalInfo;
        this.district = district;
        this.postalCode = postalCode;
        this.city = city;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public CityEntity getCityEntity() {
        return city;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.city = cityEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
