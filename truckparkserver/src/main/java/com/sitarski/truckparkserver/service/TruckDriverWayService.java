package com.sitarski.truckparkserver.service;

import com.sitarski.truckparkserver.dao.CompanyRepository;
import com.sitarski.truckparkserver.dao.DriverRepository;
import com.sitarski.truckparkserver.dao.TruckDriverWayRepository;
import com.sitarski.truckparkserver.dao.TruckRepository;
import com.sitarski.truckparkserver.domain.dto.CompanyDto;
import com.sitarski.truckparkserver.domain.dto.DriverDto;
import com.sitarski.truckparkserver.domain.dto.TruckDriverWayDto;
import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.domain.entity.Company;
import com.sitarski.truckparkserver.domain.entity.Driver;
import com.sitarski.truckparkserver.domain.entity.Truck;
import com.sitarski.truckparkserver.domain.entity.TruckDriverWay;
import com.sitarski.truckparkserver.service.mapper.Mapper;
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
    private final Mapper<TruckDriverWayDto, TruckDriverWay> truckDriverWayMapper;

    @Autowired
    private final TruckRepository truckRepository;

    @Autowired
    private final CompanyRepository companyRepository;

    @Autowired
    private final DriverRepository driverRepository;

    public TruckDriverWayService(TruckDriverWayRepository truckDriverWayRepository, TruckDriverWayMapper truckDriverWayMapper, TruckRepository truckRepository, CompanyRepository companyRepository, DriverRepository driverRepository) {
        this.truckDriverWayRepository = truckDriverWayRepository;
        this.truckDriverWayMapper = truckDriverWayMapper;
        this.truckRepository = truckRepository;
        this.companyRepository = companyRepository;
        this.driverRepository = driverRepository;
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

    public void addTruckDriverWay(TruckDriverWayDto truckDriverWayDto) {
        TruckDriverWay truckDriverWayToSave = truckDriverWayMapper.convertToEntity(truckDriverWayDto);
        truckDriverWayRepository.save(truckDriverWayToSave);
    }
}
