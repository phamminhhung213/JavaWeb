package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.model.Services;
import com.codegym.casestudy.repository.ContractRepository;
import com.codegym.casestudy.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;


    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findAllByCustomer(Customer customer, Pageable pageable) {
        return contractRepository.findAllByCustomer(customer, pageable);
    }

    @Override
    public Page<Contract> findAllByEmployee(Employee employee, Pageable pageable) {
        return contractRepository.findAllByEmployee(employee, pageable);
    }

    @Override
    public Page<Contract> findAllByServices(Services services, Pageable pageable) {
        return contractRepository.findAllByServices(services, pageable);
    }

    @Override
    public Page<Contract> findByBeginDateContaining(Date beginDate, Pageable pageable) {
        return contractRepository.findByBeginDateContaining(beginDate, pageable);
    }
}
