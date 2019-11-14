package com.sitarski.truckparkserver.service.mapper;

import com.sitarski.truckparkserver.domain.dto.UserSystemDto;
import com.sitarski.truckparkserver.domain.entity.UserSystem;
import com.sitarski.truckparkserver.service.configuration.ModelMapperConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSystemMapper implements Mapper<UserSystemDto, UserSystem> {

    @Autowired
    private final ModelMapperConfiguration modelMapperConfiguration;

    public UserSystemMapper(ModelMapperConfiguration modelMapperConfiguration){
        this.modelMapperConfiguration = modelMapperConfiguration;
    }

    @Override
    public UserSystemDto convertToDto(UserSystem userSystem) {

        UserSystemDto userSystemDto = modelMapperConfiguration.modelMapper().map(userSystem, UserSystemDto.class);

        return userSystemDto;
    }

    @Override
    public UserSystem convertToEntity(UserSystemDto userSystemDto) {

        UserSystem userSystem = modelMapperConfiguration.modelMapper().map(userSystemDto, UserSystem.class);

        return userSystem;
    }
}
