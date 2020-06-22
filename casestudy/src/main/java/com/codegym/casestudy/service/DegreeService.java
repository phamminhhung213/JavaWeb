package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Degree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DegreeService {
    Degree findById(Long id);

    void save(Degree degree);

    void remove(Long id);

    Page<Degree> findAll(Pageable pageable);
}
