package com.caiorib.spring.course.services;

import com.caiorib.spring.course.domain.OrderEntity;

public interface OrderService {

    OrderEntity findOne(Long id);

}
