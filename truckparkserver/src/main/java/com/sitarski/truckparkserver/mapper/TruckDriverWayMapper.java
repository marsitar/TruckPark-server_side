package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.configuration.ModelMapperConfiguration;
import com.sitarski.truckparkserver.dao.DriverRepository;
import com.sitarski.truckparkserver.dao.TruckRepository;
import com.sitarski.truckparkserver.domain.dto.TruckDriverWayDto;
import com.sitarski.truckparkserver.domain.dto.TruckDriverWayDtoCreate;
import com.sitarski.truckparkserver.domain.entity.Driver;
import com.sitarski.truckparkserver.domain.entity.Truck;
import com.sitarski.truckparkserver.domain.entity.TruckDriverWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TruckDriverWayMapper implements Mapper<TruckDriverWayDto, TruckDriverWay> {

    private final TruckRepository truckRepository;
    private final DriverRepository driverRepository;
    private final ModelMapperConfiguration modelMapperConfiguration;

    @Autowired
    public TruckDriverWayMapper(ModelMapperConfiguration modelMapperConfiguration, TruckRepository truckRepository, DriverRepository driverRepository) {
        this.modelMapperConfiguration = modelMapperConfiguration;
        this.truckRepository = truckRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public TruckDriverWayDto convertToDto(TruckDriverWay truckDriverWay) {

        TruckDriverWayDto truckDriverWayDto = modelMapperConfiguration.modelMapper().map(truckDriverWay, TruckDriverWayDto.class);

        return truckDriverWayDto;
    }

    @Override
    public TruckDriverWay convertToEntity(TruckDriverWayDto truckDriverWayDto) {

        TruckDriverWay truckDriverWay = modelMapperConfiguration.modelMapper().map(truckDriverWayDto, TruckDriverWay.class);

        return truckDriverWay;
    }

    public TruckDriverWay convertToEntity(TruckDriverWayDtoCreate truckDriverWayDtoCreate) {

        TruckDriverWay truckDriverWay = modelMapperConfiguration.modelMapper().map(truckDriverWayDtoCreate, TruckDriverWay.class);

        Long truckId = truckDriverWayDtoCreate.getTruckId();
        Truck truck = truckRepository.findById(truckId).orElse(null);

        Long driverId = truckDriverWayDtoCreate.getDriverId();
        Driver driver = driverRepository.findById(driverId).orElse(null);

        truckDriverWay.setTruck(truck);
        truckDriverWay.setDriver(driver);

        return truckDriverWay;

    }
}