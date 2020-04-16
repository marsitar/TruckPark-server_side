package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.domain.dto.CoordinateDto;
import com.sitarski.truckparkserver.domain.entity.Coordinate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoordinateMapper {

    public CoordinateDto convertToDTO(Coordinate coordinate) {

        Long id = Optional.of(coordinate)
                .map(Coordinate::getId)
                .orElse(null);

        Double lat = Optional.of(coordinate)
                .map(Coordinate::getLat)
                .orElse(null);

        Double lng = Optional.of(coordinate)
                .map(Coordinate::getLng)
                .orElse(null);

        CoordinateDto coordinateDTO = new CoordinateDto();

        coordinateDTO.setId(id);
        coordinateDTO.setLat(lat);
        coordinateDTO.setLng(lng);

        return coordinateDTO;
    }

    public Coordinate convertToEntity(CoordinateDto coordinateDTO) {

        Long id = Optional.of(coordinateDTO)
                .map(CoordinateDto::getId)
                .orElse(null);

        Double lat = Optional.of(coordinateDTO)
                .map(CoordinateDto::getLat)
                .orElseThrow();

        Double lng = Optional.of(coordinateDTO)
                .map(CoordinateDto::getLng)
                .orElseThrow();

        Coordinate coordinate = new Coordinate();

        coordinate.setId(id);
        coordinate.setLat(lat);
        coordinate.setLng(lng);

        return coordinate;
    }
}
