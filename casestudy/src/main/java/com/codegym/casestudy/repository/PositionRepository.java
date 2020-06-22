package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
