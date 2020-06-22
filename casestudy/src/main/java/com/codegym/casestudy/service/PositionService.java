package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PositionService {
    Position findById(Long id);

    void save(Position position);

    void remove(Long id);

    Page<Position> findAll(Pageable pageable);
}
