package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    Page<Contract> findAllByCustomer(Customer customer, Pageable pageable);

    Page<Contract> findAllByEmployee(Employee employee, Pageable pageable);

    Page<Contract> findAllByServices(Services services, Pageable pageable);

    Page<Contract> findByBeginDateContaining(Date beginDate, Pageable pageable);
}
