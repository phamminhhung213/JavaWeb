package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Services;
import com.codegym.casestudy.repository.ServicesRepository;
import com.codegym.casestudy.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public Services findById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Services services) {
        servicesRepository.save(services);
    }

    @Override
    public void remove(Long id) {
        servicesRepository.deleteById(id);
    }

    @Override
    public Page<Services> findAll(Pageable pageable) {
        return servicesRepository.findAll(pageable);
    }

    @Override
    public Page<Services> findByServiceNameContaining(String serviceName, Pageable pageable) {
        return servicesRepository.findByServiceNameContaining(serviceName, pageable);
    }
}
