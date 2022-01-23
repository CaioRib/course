package com.caiorib.spring.course.dto.request;

import com.caiorib.spring.course.services.validation.InsertCustomer;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@InsertCustomer
public class CreateCustomerRequestBody implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome é obrigatório.")
    @Length(min=5, max=120, message = "Nome com tamanho entre {min} e {max}")
    private String name;

    @NotEmpty(message = "E-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotEmpty(message = "CPF/CNPJ é obrigatório.")
    private String legalId;

    @NotNull(message = "Tipo é obrigatório.")
    private Long type;

    @NotEmpty(message = "Logradouro é obrigatório.")
    private String place;

    @NotNull(message = "N[umero é obrigatório.")
    private Long number;

    private String additionalInfo;

    @NotEmpty(message = "Bairro é obrigatório.")
    private String district;

    @NotEmpty(message = "CEP é obrigatório.")
    private String postalCode;

    @NotEmpty(message = "Pelo menos um telefone é obrigatório.")
    private String phone1;
    private String phone2;
    private String phone3;

    @NotNull(message = "Cidade é obrigatória.")
    private Long cityId;

    public CreateCustomerRequestBody() {
    }

    public CreateCustomerRequestBody(String name, String email, String legalId, Long type, String place, Long number, String additionalInfo, String district, String postalCode, String phone1, String phone2, String phone3) {
        this.name = name;
        this.email = email;
        this.legalId = legalId;
        this.type = type;
        this.place = place;
        this.number = number;
        this.additionalInfo = additionalInfo;
        this.district = district;
        this.postalCode = postalCode;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
