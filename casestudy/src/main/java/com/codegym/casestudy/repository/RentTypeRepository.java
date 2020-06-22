package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<RentType, Long> {
}
