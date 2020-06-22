package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartService {
    Part findById(Long id);

    void save(Part part);

    void remove(Long id);

    Page<Part> findAll(Pageable pageable);
}
