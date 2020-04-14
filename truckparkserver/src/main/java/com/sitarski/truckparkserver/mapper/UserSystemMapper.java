package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.domain.dto.UserSystemDto;
import com.sitarski.truckparkserver.domain.entity.UserSystem;
import org.springframework.stereotype.Service;

@Service
public class UserSystemMapper implements Mapper<UserSystemDto, UserSystem> {

    @Override
    public UserSystemDto convertToDto(UserSystem userSystem) {

        Long id = userSystem.getId();
        String emailAddress = userSystem.getEmailAdress();
        String systemRole = userSystem.getSystemRole();
        String login = userSystem.getLogin();

        UserSystemDto userSystemDto = new UserSystemDto();

        userSystemDto.setId(id);
        userSystemDto.setEmailAdress(emailAddress);
        userSystemDto.setSystemRole(systemRole);
        userSystemDto.setLogin(login);

        return userSystemDto;
    }

    @Override
    public UserSystem convertToEntity(UserSystemDto userSystemDto) {

        Long id = userSystemDto.getId();
        String emailAddress = userSystemDto.getEmailAdress();
        String systemRole = userSystemDto.getSystemRole();
        String login = userSystemDto.getLogin();

        UserSystem userSystem = new UserSystem();

        userSystem.setId(id);
        userSystem.setEmailAdress(emailAddress);
        userSystem.setSystemRole(systemRole);
        userSystem.setLogin(login);

        return userSystem;
    }
}
