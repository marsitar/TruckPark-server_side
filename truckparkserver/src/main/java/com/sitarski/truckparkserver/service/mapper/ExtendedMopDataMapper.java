package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.ExtendedMopDataDto;
import com.sitarski.truckparkserver.domain.entity.ExtendedMopData;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtendedMopDataMapper implements Mapper<ExtendedMopDataDto, ExtendedMopData> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public ExtendedMopDataMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    @Override
    public ExtendedMopDataDto convertToDto(ExtendedMopData extendedMopData) {

        ExtendedMopDataDto extendedMopDataDto = modelMapperConfiguration.modelMapper().map(extendedMopData, ExtendedMopDataDto.class);

        return extendedMopDataDto;
    }

    @Override
    public ExtendedMopData convertToEntity(ExtendedMopDataDto extendedMopDataDto) {

        ExtendedMopData extendedMopData = modelMapperConfiguration.modelMapper().map(extendedMopDataDto, ExtendedMopData.class);

        return extendedMopData;
    }
}
