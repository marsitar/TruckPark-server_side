package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.dao.DriverRepository;
import com.sitarski.truckparkserver.dao.TruckRepository;
import com.sitarski.truckparkserver.domain.dto.CoordinateDto;
import com.sitarski.truckparkserver.domain.dto.TruckDriverWayDto;
import com.sitarski.truckparkserver.domain.dto.TruckDriverWayDtoCreate;
import com.sitarski.truckparkserver.domain.entity.Coordinate;
import com.sitarski.truckparkserver.domain.entity.Driver;
import com.sitarski.truckparkserver.domain.entity.Truck;
import com.sitarski.truckparkserver.domain.entity.TruckDriverWay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class TruckDriverWayMapper implements Mapper<TruckDriverWayDto, TruckDriverWay> {

    private final TruckRepository truckRepository;
    private final DriverRepository driverRepository;
    private final CoordinateMapper coordinateMapper;

    @Autowired
    public TruckDriverWayMapper(TruckRepository truckRepository, DriverRepository driverRepository, CoordinateMapper coordinateMapper) {
        this.truckRepository = truckRepository;
        this.driverRepository = driverRepository;
        this.coordinateMapper = coordinateMapper;
    }

    @Override
    public TruckDriverWayDto convertToDto(TruckDriverWay truckDriverWay) {

        Long id = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getId)
                .orElseThrow();

        Double fuel = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getFuel)
                .orElseThrow();

        Double distance = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getDistance)
                .orElseThrow();

        LocalDateTime resultTime = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getResultTime)
                .orElseThrow();

        CoordinateDto coordinateDto = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getCoordinate)
                .map(coordinateMapper::convertToDTO)
                .orElse(null);

        Long truckId = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getTruck)
                .map(Truck::getId)
                .orElseThrow();

        Long driverId = Optional.of(truckDriverWay)
                .map(TruckDriverWay::getDriver)
                .map(Driver::getId)
                .orElseThrow();

        TruckDriverWayDto truckDriverWayDto = new TruckDriverWayDto();

        truckDriverWayDto.setId(id);
        truckDriverWayDto.setFuel(fuel);
        truckDriverWayDto.setDistance(distance);
        truckDriverWayDto.setResultTime(resultTime);
        truckDriverWayDto.setCoordinateDTO(coordinateDto);
        truckDriverWayDto.setTruckId(truckId);
        truckDriverWayDto.setDriverId(driverId);

        return truckDriverWayDto;
    }

    @Override
    public TruckDriverWay convertToEntity(TruckDriverWayDto truckDriverWayDto) {

        Long id = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getId)
                .orElseThrow();

        Double fuel = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getFuel)
                .orElseThrow();

        Double distance = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getDistance)
                .orElseThrow();

        LocalDateTime resultTime = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getResultTime)
                .orElseThrow();

        Coordinate coordinate = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getCoordinateDTO)
                .map(coordinateMapper::convertToEntity)
                .orElse(null);

        Truck truck = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getTruckId)
                .flatMap(truckRepository::findById)
                .orElseThrow();

        Driver driver = Optional.of(truckDriverWayDto)
                .map(TruckDriverWayDto::getDriverId)
                .flatMap(driverRepository::findById)
                .orElseThrow();

        TruckDriverWay truckDriverWay = new TruckDriverWay();

        truckDriverWay.setId(id);
        truckDriverWay.setFuel(fuel);
        truckDriverWay.setDistance(distance);
        truckDriverWay.setResultTime(resultTime);
        truckDriverWay.setCoordinate(coordinate);
        truckDriverWay.setTruck(truck);
        truckDriverWay.setDriver(driver);

        return truckDriverWay;
    }

    public TruckDriverWay convertToEntity(TruckDriverWayDtoCreate truckDriverWayDtoCreate) {

        Double fuel = Optional.of(truckDriverWayDtoCreate)
                .map(TruckDriverWayDtoCreate::getFuel)
                .orElseThrow();

        Double distance = Optional.of(truckDriverWayDtoCreate)
                .map(TruckDriverWayDtoCreate::getDistance)
                .orElseThrow();

        LocalDateTime resultTime = Optional.of(truckDriverWayDtoCreate)
                .map(TruckDriverWayDtoCreate::getResultTime)
                .orElseThrow();

        Coordinate coordinate = Optional.of(truckDriverWayDtoCreate)
                .map(TruckDriverWayDtoCreate::getCoordinateDto)
                .map(coordinateMapper::convertToEntity)
                .orElse(null);

        Driver driver = Optional.of(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(Object::toString)
                .flatMap(driverRepository::findDriverByFullName)
                .orElseThrow();

        Truck truck = Optional.of(driver)
                .map(Driver::getTruck)
                .orElseThrow();

        TruckDriverWay truckDriverWay = new TruckDriverWay();

        truckDriverWay.setFuel(fuel);
        truckDriverWay.setDistance(distance);
        truckDriverWay.setCoordinate(coordinate);
        truckDriverWay.setResultTime(resultTime);
        truckDriverWay.setTruck(truck);
        truckDriverWay.setDriver(driver);

        return truckDriverWay;

    }
}
