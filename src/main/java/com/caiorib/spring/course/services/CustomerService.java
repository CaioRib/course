package com.caiorib.spring.course.services;

import com.caiorib.spring.course.domain.CustomerEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    CustomerEntity findOne(Long id);

    public List<CustomerEntity> findAll();

    CustomerEntity createCustomer(CustomerEntity customerEntity);

    CustomerEntity updateCustomer(CustomerEntity categoryEntity);

    void deleteCustomer(Long id);

    Page<CustomerEntity> findPaged(Integer page, Integer size, String orderBy, String direction);

}
