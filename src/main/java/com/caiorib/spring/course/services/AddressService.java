package com.caiorib.spring.course.services;

import com.caiorib.spring.course.domain.AddressEntity;

import java.util.List;

public interface AddressService {

    AddressEntity findOne(Long id);

    List<AddressEntity> findAll();

    AddressEntity createAddress(AddressEntity addressEntity);

}
