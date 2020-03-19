package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.configuration.ModelMapperConfiguration;
import com.sitarski.truckparkserver.domain.dto.TruckDto;
import com.sitarski.truckparkserver.domain.entity.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckMapper implements Mapper<TruckDto, Truck> {

    private final ModelMapperConfiguration modelMapperConfiguration;

    @Autowired
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
