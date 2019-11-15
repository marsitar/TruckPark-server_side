package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.DriverDto;
import com.sitarski.truckparkserver.domain.entity.Driver;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverMapper implements Mapper<DriverDto, Driver> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public DriverMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    @Override
    public DriverDto convertToDto(Driver driver) {

        DriverDto driverDTO = modelMapperConfiguration.modelMapper().map(driver, DriverDto.class);

        return driverDTO;
    }

    @Override
    public Driver convertToEntity(DriverDto driverDto) {

        Driver driver = modelMapperConfiguration.modelMapper().map(driverDto, Driver.class);

        return driver;
    }
}
