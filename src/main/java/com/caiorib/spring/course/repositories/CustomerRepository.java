package com.caiorib.spring.course.repositories;

import com.caiorib.spring.course.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    @Transactional(readOnly = true)
    CustomerEntity findByEmail(String email);
}
