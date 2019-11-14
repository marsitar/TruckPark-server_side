package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.CoordinateDto;
import com.sitarski.truckparkserver.domain.entity.Coordinate;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateMapper {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public CoordinateMapper(ModelMapperConfiguration modelMapperConfiguration) {
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    public CoordinateDto convertToDTO(Coordinate coordinate) {

        CoordinateDto coordinateDTO = modelMapperConfiguration.modelMapper().map(coordinate, CoordinateDto.class);

        return coordinateDTO;
    }

    public Coordinate convertToEntity(CoordinateDto coordinateDTO) {

        Coordinate coordinate = modelMapperConfiguration.modelMapper().map(coordinateDTO, Coordinate.class);

        return coordinate;
    }
}
