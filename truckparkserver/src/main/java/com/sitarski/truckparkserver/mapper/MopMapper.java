package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.configuration.ModelMapperConfiguration;
import com.sitarski.truckparkserver.domain.dto.CoordinateDto;
import com.sitarski.truckparkserver.domain.dto.ExtendedMopDataDto;
import com.sitarski.truckparkserver.domain.dto.MopDto;
import com.sitarski.truckparkserver.domain.entity.Mop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MopMapper implements Mapper<MopDto, Mop> {

    private final ModelMapperConfiguration modelMapperConfiguration;
    private final CoordinateMapper coordinateMapper;
    private final ExtendedMopDataMapper extendedMopDataMapper;

    @Autowired
    public MopMapper(ModelMapperConfiguration modelMapperConfiguration, CoordinateMapper coordinateMapper, ExtendedMopDataMapper extendedMopDataMapper){
        this.modelMapperConfiguration = modelMapperConfiguration;
        this.coordinateMapper = coordinateMapper;
        this.extendedMopDataMapper = extendedMopDataMapper;
    }

    @Override
    public MopDto convertToDto(Mop mop) {

        CoordinateDto coordinateDto = Optional.of(mop)
                .map(Mop::getCoordinate)
                .map(coordinateMapper::convertToDTO)
                .orElse(null);

        ExtendedMopDataDto extendedMopDataDTO = Optional.of(mop)
                .map(Mop::getExtendedMopData)
                .map(extendedMopDataMapper::convertToDto)
                .orElse(null);

        MopDto mopDto = modelMapperConfiguration.modelMapper().map(mop, MopDto.class);

        mopDto.setCoordinateDTO(coordinateDto);
        mopDto.setExtendedMopDataDTO(extendedMopDataDTO);

        return mopDto;
    }

    @Override
    public Mop convertToEntity(MopDto mopDto) {

        Mop mop = modelMapperConfiguration.modelMapper().map(mopDto, Mop.class);

        return mop;
    }
}
