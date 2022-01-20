package com.caiorib.spring.course.dto.mapper;

import com.caiorib.spring.course.domain.AddressEntity;
import com.caiorib.spring.course.domain.CityEntity;
import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.domain.enums.CustomerTypeEnum;
import com.caiorib.spring.course.dto.request.CreateCustomerRequestBody;

import java.util.Objects;

public class CustomerMapper {

    public static CustomerEntity fromCreateCustomerRequestBody(CreateCustomerRequestBody requestBody){
        CustomerEntity customer = new CustomerEntity(null, requestBody.getName(), requestBody.getEmail(), requestBody.getLegalId(), CustomerTypeEnum.toEnum(requestBody.getType()));
        CityEntity city = new CityEntity(requestBody.getCityId(), null, null);
        AddressEntity address = new AddressEntity(null, requestBody.getPlace(), requestBody.getNumber(), requestBody.getAdditionalInfo(), requestBody.getDistrict(), requestBody.getPostalCode(), customer, city);
        customer.getAddresses().add(address);
        customer.getPhones().add(requestBody.getPhone1());
        if(Objects.nonNull(requestBody.getPhone2())) {
            customer.getPhones().add(requestBody.getPhone2());
        }
        if(Objects.nonNull(requestBody.getPhone3())) {
            customer.getPhones().add(requestBody.getPhone3());
        }

        return customer;

    }
}
