package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.domain.dto.CoordinateDto;
import com.sitarski.truckparkserver.domain.dto.ExtendedMopDataDto;
import com.sitarski.truckparkserver.domain.dto.MopDto;
import com.sitarski.truckparkserver.domain.entity.Coordinate;
import com.sitarski.truckparkserver.domain.entity.ExtendedMopData;
import com.sitarski.truckparkserver.domain.entity.Mop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MopMapper implements Mapper<MopDto, Mop> {

    private final CoordinateMapper coordinateMapper;
    private final ExtendedMopDataMapper extendedMopDataMapper;

    @Autowired
    public MopMapper(CoordinateMapper coordinateMapper, ExtendedMopDataMapper extendedMopDataMapper){
        this.coordinateMapper = coordinateMapper;
        this.extendedMopDataMapper = extendedMopDataMapper;
    }

    @Override
    public MopDto convertToDto(Mop mop) {

        Long id = Optional.of(mop)
                .map(Mop::getId)
                .orElseThrow();

        String identificationName = Optional.of(mop)
                .map(Mop::getIdentificationName)
                .orElseThrow();

        String category = Optional.of(mop)
                .map(Mop::getCategory)
                .orElseThrow();

        String place = Optional.of(mop)
                .map(Mop::getPlace)
                .orElseThrow();

        CoordinateDto coordinateDto = Optional.of(mop)
                .map(Mop::getCoordinate)
                .map(coordinateMapper::convertToDTO)
                .orElse(null);

        String roadNumber = Optional.of(mop)
                .map(Mop::getRoadNumber)
                .orElseThrow();

        Integer truckPlaces = Optional.of(mop)
                .map(Mop::getTruckPlaces)
                .orElseThrow();

        Integer occupiedTruckPlaces = Optional.of(mop)
                .map(Mop::getOccupiedTruckPlaces)
                .orElseThrow();

        String extendedId = Optional.of(mop)
                .map(Mop::getExtendedId)
                .orElseThrow();

        ExtendedMopDataDto extendedMopDataDTO = Optional.of(mop)
                .map(Mop::getExtendedMopData)
                .map(extendedMopDataMapper::convertToDto)
                .orElse(null);

        MopDto mopDto = new MopDto();

        mopDto.setId(id);
        mopDto.setIdentificationName(identificationName);
        mopDto.setCategory(category);
        mopDto.setPlace(place);
        mopDto.setCoordinateDTO(coordinateDto);
        mopDto.setRoadNumber(roadNumber);
        mopDto.setTruckPlaces(truckPlaces);
        mopDto.setOccupiedTruckPlaces(occupiedTruckPlaces);
        mopDto.setExtendedId(extendedId);
        mopDto.setExtendedMopDataDTO(extendedMopDataDTO);

        return mopDto;
    }

    @Override
    public Mop convertToEntity(MopDto mopDto) {

        String identificationName = Optional.of(mopDto)
                .map(MopDto::getIdentificationName)
                .orElseThrow();

        String category = Optional.of(mopDto)
                .map(MopDto::getCategory)
                .orElseThrow();

        String place = Optional.of(mopDto)
                .map(MopDto::getPlace)
                .orElseThrow();

        Coordinate coordinate = Optional.of(mopDto)
                .map(MopDto::getCoordinateDTO)
                .map(coordinateMapper::convertToEntity)
                .orElse(null);

        String roadNumber = Optional.of(mopDto)
                .map(MopDto::getRoadNumber)
                .orElseThrow();

        Integer truckPlaces = Optional.of(mopDto)
                .map(MopDto::getTruckPlaces)
                .orElseThrow();

        Integer occupiedTruckPlaces = Optional.of(mopDto)
                .map(MopDto::getOccupiedTruckPlaces)
                .orElseThrow();

        String extendedId = Optional.of(mopDto)
                .map(MopDto::getExtendedId)
                .orElseThrow();

        ExtendedMopData extendedMopData = Optional.of(mopDto)
                .map(MopDto::getExtendedMopDataDTO)
                .map(extendedMopDataMapper::convertToEntity)
                .orElse(null);

        Mop mop = new Mop();

        mop.setIdentificationName(identificationName);
        mop.setCategory(category);
        mop.setPlace(place);
        mop.setCoordinate(coordinate);
        mop.setRoadNumber(roadNumber);
        mop.setTruckPlaces(truckPlaces);
        mop.setOccupiedTruckPlaces(occupiedTruckPlaces);
        mop.setExtendedId(extendedId);
        mop.setExtendedMopData(extendedMopData);

        return mop;
    }
}
