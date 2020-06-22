package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ServicesRepository extends JpaRepository<Services, Long> {
    Page<Services> findByServiceNameContaining(String serviceName, Pageable pageable);
}
