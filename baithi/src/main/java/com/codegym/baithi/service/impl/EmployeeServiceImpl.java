package com.codegym.baithi.service.impl;

import com.codegym.baithi.model.Employee;
import com.codegym.baithi.model.Part;
import com.codegym.baithi.repository.EmployeeRepository;
import com.codegym.baithi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByPart(Part part, Pageable pageable) {
        return employeeRepository.findAllByPart(part, pageable);
    }

    @Override
    public Page<Employee> findByFullNameContaining(String fullName, Pageable pageable) {
        return employeeRepository.findByFullNameContaining(fullName, pageable);
    }

    @Override
    public Page<Employee> findByCodeEmployee(String codeEmployee, Pageable pageable) {
        return employeeRepository.findByCodeEmployee(codeEmployee,pageable);
    }

    @Override
    public Page<Employee> findByIdNumber(String idNumber, Pageable pageable) {
        return employeeRepository.findByIdNumber(idNumber, pageable);
    }
}
