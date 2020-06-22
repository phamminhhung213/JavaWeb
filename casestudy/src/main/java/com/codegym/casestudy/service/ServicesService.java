package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServicesService {
    Services findById(Long id);

    void save(Services services);

    void remove(Long id);

    Page<Services> findAll(Pageable pageable);

    Page<Services> findByServiceNameContaining(String serviceName, Pageable pageable);

}
