package com.caiorib.spring.course.resources;

import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.dto.mapper.CustomerMapper;
import com.caiorib.spring.course.dto.request.CreateCustomerRequestBody;
import com.caiorib.spring.course.dto.response.CustomerResponseBody;
import com.caiorib.spring.course.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerEntity> findONe(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseBody>> findAll() {
        return ResponseEntity.ok().body(customerService.findAll()
                .stream()
                .map(customer -> new CustomerResponseBody(customer.getName(), customer.getEmail()))
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> createCustomer(@Valid @RequestBody CreateCustomerRequestBody customerRequestBody) {
        CustomerEntity customer = CustomerMapper.fromCreateCustomerRequestBody(customerRequestBody);
        customer = customerService.createCustomer(customer);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCustomer(@Valid @RequestBody CustomerResponseBody customerRequestBody, @PathVariable Long id) {
        final CustomerEntity customer = customerRequestBody.toCustomerEntity();
        customer.setId(id);
        customerService.updateCustomer(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<CustomerResponseBody>> findAllPaged(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "24") Integer size,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        final Page<CustomerResponseBody> customers = customerService.findPaged(page, size, orderBy, direction).map(customer -> new CustomerResponseBody(customer.getName(), customer.getEmail()));

        return ResponseEntity.ok().body(customers);
    }

}
