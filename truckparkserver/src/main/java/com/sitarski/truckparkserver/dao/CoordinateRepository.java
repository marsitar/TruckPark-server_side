package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}
