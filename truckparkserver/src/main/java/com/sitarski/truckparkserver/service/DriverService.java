package com.sitarski.truckparkserver.service;

import com.sitarski.truckparkserver.dao.DriverRepository;
import com.sitarski.truckparkserver.domain.dto.DriverDto;
import com.sitarski.truckparkserver.domain.entity.Driver;
import com.sitarski.truckparkserver.service.mapper.DriverMapper;
import com.sitarski.truckparkserver.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {

    @Autowired
    private final DriverRepository driverRepository;

    @Autowired
    private final Mapper<DriverDto,Driver> driverMapper;

    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    public List<DriverDto> getDrivers() {
        return driverRepository
                .findAll()
                .stream()
                .map(driverMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<DriverDto> getDriverById(Long id) {
        return driverRepository
                .findById(id)
                .map(driverMapper::convertToDto);
    }

    public Optional<DriverDto> getDriverByFullName(String fullName){
        return driverRepository
                .findDriverByFullName(fullName)
                .map(driverMapper::convertToDto);
    }

    public List<DriverDto> getDriversByFullNamePattern(String fullNamePattern){
        return driverRepository
                .findDriversByFullNameIsLike(fullNamePattern)
                .stream()
                .map(driverMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public List<DriverDto> getDriversByCompanyName(String companyName){
        return driverRepository
                .findDriversByCompany_FullName(companyName)
                .stream()
                .map(driverMapper::convertToDto)
                .collect(Collectors.toList());
    }

    public void addDriver(DriverDto driverDto){
        Driver driverToSave = driverMapper.convertToEntity(driverDto);
        driverRepository.save(driverToSave);
    }

    public DriverDto updateDriver(DriverDto driverDto){
        Driver driverToSave = Optional.of(driverDto)
                .map(driverMapper::convertToEntity)
                .orElse(null);
        Driver savedDriver = driverRepository.save(driverToSave);
        return driverMapper.convertToDto(savedDriver);
    }

    public void deleteDriverById(Long id){
        driverRepository.deleteById(id);
    }
}
