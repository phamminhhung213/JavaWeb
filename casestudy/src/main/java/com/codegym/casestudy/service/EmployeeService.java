package com.codegym.casestudy.service;


import com.codegym.casestudy.model.Degree;
import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.model.Part;
import com.codegym.casestudy.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByPart(Part part, Pageable pageable);

    Page<Employee> findAllByDegree(Degree degree, Pageable pageable);

    Page<Employee> findAllByPosition(Position position, Pageable pageable);

    Page<Employee> findByFullNameContaining(String fullName, Pageable pageable);

    Page<Employee> findByPosition_Id(Long id, Pageable pageable);
}
