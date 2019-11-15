package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.TruckDriverWayDto;
import com.sitarski.truckparkserver.domain.entity.TruckDriverWay;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckDriverWayMapper implements Mapper<TruckDriverWayDto, TruckDriverWay> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public TruckDriverWayMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
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
}
