package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByFullNameContaining(String fullName, Pageable pageable);
}
