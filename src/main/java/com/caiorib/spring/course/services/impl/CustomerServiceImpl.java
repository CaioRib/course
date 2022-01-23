package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.AddressEntity;
import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.domain.CityEntity;
import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.domain.enums.CustomerTypeEnum;
import com.caiorib.spring.course.dto.request.CreateCustomerRequestBody;
import com.caiorib.spring.course.repositories.CustomerRepository;
import com.caiorib.spring.course.services.AddressService;
import com.caiorib.spring.course.services.CustomerService;
import com.caiorib.spring.course.services.exceptions.DataIntegrityException;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressService addressService;

    @Override
    public CustomerEntity findOne(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        final AddressEntity address = customerEntity.getAddresses().get(0);
        addressService.createAddress(address);
        return customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity updatedCustomer) {
        final CustomerEntity customer = findOne(updatedCustomer.getId());
        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        findOne(id);
        try {
            customerRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Cannot delete a customer which has orders.", e);

        }
    }

    @Override
    public Page<CustomerEntity> findPaged(Integer page, Integer size, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
        return customerRepository.findAll(pageRequest);

    }

}
