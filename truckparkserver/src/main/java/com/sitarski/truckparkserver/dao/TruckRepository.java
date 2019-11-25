package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckRepository extends JpaRepository<Truck, Long> {

    List<Truck> findTrucksByCompany(Company company);

    void deleteTruckByModel(String model);
}
