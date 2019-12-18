package com.sitarski.truckparkserver.service;

import com.sitarski.truckparkserver.dao.*;
import com.sitarski.truckparkserver.domain.dto.*;
import com.sitarski.truckparkserver.domain.entity.*;
import com.sitarski.truckparkserver.service.mapper.CoordinateMapper;
import com.sitarski.truckparkserver.service.mapper.TruckDriverWayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TruckDriverWayService {

    @Autowired
    private final TruckDriverWayRepository truckDriverWayRepository;

    @Autowired
    private final TruckDriverWayMapper truckDriverWayMapper;

    @Autowired
    private final TruckRepository truckRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final DriverRepository driverRepository;

    @Autowired
    private final CoordinateMapper coordinateMapper;

    @Autowired
    private final CoordinateRepository coordinateRepository;

    public TruckDriverWayService(TruckDriverWayRepository truckDriverWayRepository, TruckDriverWayMapper truckDriverWayMapper, TruckRepository truckRepository, CompanyRepository companyRepository, DriverRepository driverRepository, CoordinateMapper coordinateMapper, CoordinateRepository coordinateRepository) {
        this.truckDriverWayRepository = truckDriverWayRepository;
        this.truckDriverWayMapper = truckDriverWayMapper;
        this.truckRepository = truckRepository;
        this.companyRepository = companyRepository;
        this.driverRepository = driverRepository;
        this.coordinateMapper = coordinateMapper;
        this.coordinateRepository = coordinateRepository;
    }

    public List<TruckDriverWayDto> getTruckDriverWays() {
        return truckDriverWayRepository
                .findAll()
                .stream()
                .map(truckDriverWayMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TruckDriverWayDto> getTruckDriverWayById(Long id) {
        return truckDriverWayRepository
                .findById(id)
                .map(truckDriverWayMapper::convertToDto);
    }

    public List<TruckDriverWayDto> getTruckDriverWaysByDriver(DriverDto driverDto) {
        Long foundDriverId = Optional.ofNullable(driverDto)
                .map(DriverDto::getId)
                .orElse(null);

        Driver foundDriver = driverRepository.findById(foundDriverId)
                .orElse(null);


        return truckDriverWayRepository
                .findAllByDriver(foundDriver)
                .stream()
                .map(truckDriverWayMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<TruckDriverWayDto> getTruckDriverWaysByTruck(TruckDto truckDto) {

        Long foundTruckId = Optional.ofNullable(truckDto)
                .map(TruckDto::getId)
                .orElse(null);

        Truck foundTruck = truckRepository.findById(foundTruckId)
                .orElse(null);

        return truckDriverWayRepository
                .findAllByTruck(foundTruck)
                .stream()
                .map(truckDriverWayMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<TruckDriverWayDto> getTruckDriverWaysByDriversCompany(CompanyDto companyDto) {

        Long foundCompanyId = Optional.ofNullable(companyDto)
                .map(CompanyDto::getId)
                .orElse(null);

        Company foundCompany = companyRepository.findById(foundCompanyId)
                .orElse(null);

        return truckDriverWayRepository
                .findTruckDriverWaysByDriver_Company(foundCompany)
                .stream()
                .map(truckDriverWayMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public void addTruckDriverWay(TruckDriverWayDtoCreate truckDriverWayDtoCreate) {
        TruckDriverWay truckDriverWayToSave = truckDriverWayMapper.convertToEntity(truckDriverWayDtoCreate);

        CoordinateDto coordinateDto = truckDriverWayDtoCreate.getCoordinateDto();
        Coordinate coordinate = coordinateMapper.convertToEntity(coordinateDto);

        TruckDriverWay savedTruckDriverWay = truckDriverWayRepository.save(truckDriverWayToSave);
        savedTruckDriverWay.setCoordinate(coordinate);
    }
}
