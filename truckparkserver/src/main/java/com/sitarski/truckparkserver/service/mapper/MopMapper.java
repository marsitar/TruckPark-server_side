package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.MopDto;
import com.sitarski.truckparkserver.domain.entity.Mop;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MopMapper implements Mapper<MopDto, Mop> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public MopMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    @Override
    public MopDto convertToDto(Mop mop) {

        MopDto mopDto = modelMapperConfiguration.modelMapper().map(mop, MopDto.class);

        return mopDto;
    }

    @Override
    public Mop convertToEntity(MopDto mopDto) {

        Mop mop = modelMapperConfiguration.modelMapper().map(mopDto, Mop.class);

        return mop;
    }
}
