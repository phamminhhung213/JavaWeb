package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Degree;
import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.model.Part;
import com.codegym.casestudy.model.Position;
import com.codegym.casestudy.repository.EmployeeRepository;
import com.codegym.casestudy.service.EmployeeService;
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
    public Page<Employee> findAllByDegree(Degree degree, Pageable pageable) {
        return employeeRepository.findAllByDegree(degree, pageable);
    }

    @Override
    public Page<Employee> findAllByPosition(Position position, Pageable pageable) {
        return employeeRepository.findAllByPosition(position, pageable);
    }

    @Override
    public Page<Employee> findByFullNameContaining(String fullName, Pageable pageable) {
        return employeeRepository.findByFullNameContaining(fullName,pageable);
    }

    @Override
    public Page<Employee> findByPosition_Id(Long id, Pageable pageable) {
        return employeeRepository.findByPosition_Id(id, pageable);
    }

}
