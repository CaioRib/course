package com.caiorib.spring.course.services;

import com.caiorib.spring.course.domain.CustomerEntity;

public interface CustomerService {

    CustomerEntity findOne(Long id);

}
