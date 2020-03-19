package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.configuration.ModelMapperConfiguration;
import com.sitarski.truckparkserver.domain.dto.CoordinateDto;
import com.sitarski.truckparkserver.domain.entity.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateMapper {

    private final ModelMapperConfiguration modelMapperConfiguration;

    @Autowired
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
