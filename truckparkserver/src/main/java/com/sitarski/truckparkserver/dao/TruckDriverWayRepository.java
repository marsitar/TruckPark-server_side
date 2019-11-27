package com.sitarski.truckparkserver.dao;

import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Truck;
import com.sitarski.truckparkserver.domain.entity.TruckDriverWay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TruckDriverWayRepository extends JpaRepository<TruckDriverWay, Long> {

    List<TruckDriverWay> findAllByDriver_FullName(String driverFullName);

    List<TruckDriverWay> findAllByTruck(Truck truck);

    List<TruckDriverWay> findTruckDriverWaysByDriver_Company(Company company);

}
