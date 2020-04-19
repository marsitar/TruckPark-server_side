package com.sitarski.truckparkserver.mapper;

import com.sitarski.truckparkserver.domain.dto.ExtendedMopDataDto;
import com.sitarski.truckparkserver.domain.entity.ExtendedMopData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExtendedMopDataMapper implements Mapper<ExtendedMopDataDto, ExtendedMopData> {

    @Override
    public ExtendedMopDataDto convertToDto(ExtendedMopData extendedMopData) {

        Long id = Optional.of(extendedMopData)
                .map(ExtendedMopData::getId)
                .orElseThrow();

        String organization = Optional.of(extendedMopData)
                .map(ExtendedMopData::getOrganization)
                .orElseThrow();

        String roadClass = Optional.of(extendedMopData)
                .map(ExtendedMopData::getRoadClass)
                .orElseThrow();

        String direction = Optional.of(extendedMopData)
                .map(ExtendedMopData::getDirection)
                .orElseThrow();

        Integer passengerPlaces = Optional.of(extendedMopData)
                .map(ExtendedMopData::getPassengerPlaces)
                .orElseThrow();

        Integer coachPlaces = Optional.of(extendedMopData)
                .map(ExtendedMopData::getCoachPlaces)
                .orElseThrow();

        Boolean isGuarded = Optional.of(extendedMopData)
                .map(ExtendedMopData::getGuarded)
                .orElseThrow();

        Boolean isFenced = Optional.of(extendedMopData)
                .map(ExtendedMopData::getFenced)
                .orElseThrow();

        Boolean isSecurityCamera = Optional.of(extendedMopData)
                .map(ExtendedMopData::getSecurityCamera)
                .orElseThrow();

        Boolean isPetroleum = Optional.of(extendedMopData)
                .map(ExtendedMopData::getPetroleum)
                .orElseThrow();

        Boolean isDangerousCargo = Optional.of(extendedMopData)
                .map(ExtendedMopData::getDangerousCargo)
                .orElseThrow();

        Boolean isRestaurant = Optional.of(extendedMopData)
                .map(ExtendedMopData::getRestaurant)
                .orElseThrow();

        Boolean isPlaceToStay = Optional.of(extendedMopData)
                .map(ExtendedMopData::getPlaceToStay)
                .orElseThrow();

        Boolean isToilet = Optional.of(extendedMopData)
                .map(ExtendedMopData::getToilet)
                .orElseThrow();

        Boolean isCarwash = Optional.of(extendedMopData)
                .map(ExtendedMopData::getCarwash)
                .orElseThrow();

        Boolean isWorkshop = Optional.of(extendedMopData)
                .map(ExtendedMopData::getWorkshop)
                .orElseThrow();

        Boolean isLighting = Optional.of(extendedMopData)
                .map(ExtendedMopData::getLighting)
                .orElseThrow();

        Boolean isElectricCharger = Optional.of(extendedMopData)
                .map(ExtendedMopData::getElectricCharger)
                .orElseThrow();

        String organizationInCharge = Optional.of(extendedMopData)
                .map(ExtendedMopData::getOrganizationInCharge)
                .orElseThrow();

        String organizationInChargePhone = Optional.of(extendedMopData)
                .map(ExtendedMopData::getOrganizationInChargePhone)
                .orElseThrow();

        String organizationInChargeEmail = Optional.of(extendedMopData)
                .map(ExtendedMopData::getOrganizationInChargeEmail)
                .orElseThrow();

        ExtendedMopDataDto extendedMopDataDto = new ExtendedMopDataDto();

        extendedMopDataDto.setId(id);
        extendedMopDataDto.setOrganization(organization);
        extendedMopDataDto.setRoadClass(roadClass);
        extendedMopDataDto.setDirection(direction);
        extendedMopDataDto.setPassengerPlaces(passengerPlaces);
        extendedMopDataDto.setCoachPlaces(coachPlaces);
        extendedMopDataDto.setGuarded(isGuarded);
        extendedMopDataDto.setFenced(isFenced);
        extendedMopDataDto.setSecurityCamera(isSecurityCamera);
        extendedMopDataDto.setPetroleum(isPetroleum);
        extendedMopDataDto.setDangerousCargo(isDangerousCargo);
        extendedMopDataDto.setRestaurant(isRestaurant);
        extendedMopDataDto.setPlaceToStay(isPlaceToStay);
        extendedMopDataDto.setToilet(isToilet);
        extendedMopDataDto.setCarwash(isCarwash);
        extendedMopDataDto.setWorkshop(isWorkshop);
        extendedMopDataDto.setLighting(isLighting);
        extendedMopDataDto.setElectricCharger(isElectricCharger);
        extendedMopDataDto.setOrganizationInCharge(organizationInCharge);
        extendedMopDataDto.setOrganizationInChargePhone(organizationInChargePhone);
        extendedMopDataDto.setOrganizationInChargeEmail(organizationInChargeEmail);

        return extendedMopDataDto;
    }

    @Override
    public ExtendedMopData convertToEntity(ExtendedMopDataDto extendedMopDataDto) {

        String organization = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getOrganization)
                .orElseThrow();

        String roadClass = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getRoadClass)
                .orElseThrow();

        String direction = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getDirection)
                .orElseThrow();

        Integer passengerPlaces = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getPassengerPlaces)
                .orElseThrow();

        Integer coachPlaces = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getCoachPlaces)
                .orElseThrow();

        Boolean isGuarded = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getGuarded)
                .orElseThrow();

        Boolean isFenced = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getFenced)
                .orElseThrow();

        Boolean isSecurityCamera = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getSecurityCamera)
                .orElseThrow();

        Boolean isPetroleum = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getPetroleum)
                .orElseThrow();

        Boolean isDangerousCargo = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getDangerousCargo)
                .orElseThrow();

        Boolean isRestaurant = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getRestaurant)
                .orElseThrow();

        Boolean isPlaceToStay = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getPlaceToStay)
                .orElseThrow();

        Boolean isToilet = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getToilet)
                .orElseThrow();

        Boolean isCarwash = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getCarwash)
                .orElseThrow();

        Boolean isWorkshop = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getWorkshop)
                .orElseThrow();

        Boolean isLighting = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getLighting)
                .orElseThrow();

        Boolean isElectricCharger = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getElectricCharger)
                .orElseThrow();

        String organizationInCharge = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getOrganizationInCharge)
                .orElseThrow();

        String organizationInChargePhone = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getOrganizationInChargePhone)
                .orElseThrow();

        String organizationInChargeEmail = Optional.of(extendedMopDataDto)
                .map(ExtendedMopDataDto::getOrganizationInChargeEmail)
                .orElseThrow();

        ExtendedMopData extendedMopData = new ExtendedMopData();

        extendedMopData.setOrganization(organization);
        extendedMopData.setRoadClass(roadClass);
        extendedMopData.setDirection(direction);
        extendedMopData.setPassengerPlaces(passengerPlaces);
        extendedMopData.setCoachPlaces(coachPlaces);
        extendedMopData.setGuarded(isGuarded);
        extendedMopData.setFenced(isFenced);
        extendedMopData.setSecurityCamera(isSecurityCamera);
        extendedMopData.setPetroleum(isPetroleum);
        extendedMopData.setDangerousCargo(isDangerousCargo);
        extendedMopData.setRestaurant(isRestaurant);
        extendedMopData.setPlaceToStay(isPlaceToStay);
        extendedMopData.setToilet(isToilet);
        extendedMopData.setCarwash(isCarwash);
        extendedMopData.setWorkshop(isWorkshop);
        extendedMopData.setLighting(isLighting);
        extendedMopData.setElectricCharger(isElectricCharger);
        extendedMopData.setOrganizationInCharge(organizationInCharge);
        extendedMopData.setOrganizationInChargePhone(organizationInChargePhone);
        extendedMopData.setOrganizationInChargeEmail(organizationInChargeEmail);

        return extendedMopData;
    }
}
