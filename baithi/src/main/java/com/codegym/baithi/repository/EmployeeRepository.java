package com.codegym.baithi.repository;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAllByPart(Part part, Pageable pageable);
    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);
    Page<Employee> findByCodeEmployee(String codeEmployee, Pageable pageable );
    Page<Employee> findByIdNumber(String idNumber, Pageable pageable );

}
