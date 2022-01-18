package com.caiorib.spring.course.resources;

import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerEntity> findONe(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.findOne(id));
    }

}
