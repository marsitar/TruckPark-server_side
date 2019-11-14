package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.domain.entity.Truck;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckMapper implements Mapper<TruckDto, Truck> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public TruckMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    @Override
    public TruckDto convertToDto(Truck truck) {

        TruckDto truckDto = modelMapperConfiguration.modelMapper().map(truck, TruckDto.class);

        return truckDto;
    }

    @Override
    public Truck convertToEntity(TruckDto truckDto) {

        Truck truck = modelMapperConfiguration.modelMapper().map(truckDto, Truck.class);

        return truck;
    }
}
