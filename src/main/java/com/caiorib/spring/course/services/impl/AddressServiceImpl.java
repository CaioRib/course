package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.AddressEntity;
import com.caiorib.spring.course.repositories.AddressRepository;
import com.caiorib.spring.course.services.AddressService;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressEntity findOne(Long id) {
        return addressRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

    @Override
    public List<AddressEntity> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public AddressEntity createAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }

}
