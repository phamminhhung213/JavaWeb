package com.codegym.baithi.service;

import com.codegym.baithi.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PartService {
    Part findById(Long id);

    void save(Part part);

    void remove(Long id);

    Page<Part> findAll(Pageable pageable);
}
