package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TruckRepository extends JpaRepository<Truck, Long> {

    List<Truck> findAll();

    List<Truck> findTrucksByCompany(Company company);

    Optional<Truck> findById(Long id);

    boolean existsById(Long id);

    Truck save(Truck truck);

    void deleteById(Long id);
}
