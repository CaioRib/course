package com.caiorib.spring.course.services.impl;

import com.caiorib.spring.course.domain.OrderEntity;
import com.caiorib.spring.course.repositories.OrderRepository;
import com.caiorib.spring.course.services.OrderService;
import com.caiorib.spring.course.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity findOne(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }

}
