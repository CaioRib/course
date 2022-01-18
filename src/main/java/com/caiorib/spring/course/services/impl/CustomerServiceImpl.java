package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.repositories.CustomerRepository;
import com.caiorib.spring.course.services.CustomerService;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity findOne(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

}
