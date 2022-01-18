package com.caiorib.spring.course.resources;

import com.caiorib.spring.course.domain.OrderEntity;
import com.caiorib.spring.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderEntity> findONe(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.findOne(id));
    }

}
