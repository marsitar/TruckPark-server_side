package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Mop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MopRepository extends JpaRepository<Mop, Long> {

    Optional<Mop> findMopByIdentificationName(String identificationName);

    List<Mop> findMopsByIdentificationNameIsLike (String identificationNamePattern);

}
