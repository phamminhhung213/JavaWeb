package com.codegym.baithi.service;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByPart(Part part, Pageable pageable);

    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);

    Page<Employee> findByCodeEmployee(String codeEmployee, Pageable pageable );

    Page<Employee> findByIdNumber(String idNumber, Pageable pageable );
}
