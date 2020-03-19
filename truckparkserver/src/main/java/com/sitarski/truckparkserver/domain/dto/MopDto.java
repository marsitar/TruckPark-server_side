package com.sitarski.truckparkserver.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MopDto {

    private Long id;

    private String identificationName;

    private String category;

    private String place;

    private CoordinateDto coordinateDTO;

    private String roadNumber;

    private Integer truckPlaces;

    private Integer occupiedTruckPlaces;

    private String extendedId;

    private ExtendedMopDataDto extendedMopDataDTO;

    public MopDto() {
    }

    public MopDto(String identificationName, String category, String place, CoordinateDto coordinateDTO, String roadNumber, Integer truckPlaces, Integer occupiedTruckPlaces, String extendedId, ExtendedMopDataDto extendedMopDataDTO) {
        this.identificationName = identificationName;
        this.category = category;
        this.place = place;
        this.coordinateDTO = coordinateDTO;
        this.roadNumber = roadNumber;
        this.truckPlaces = truckPlaces;
        this.occupiedTruckPlaces = occupiedTruckPlaces;
        this.extendedId = extendedId;
        this.extendedMopDataDTO = extendedMopDataDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationName() {
        return identificationName;
    }

    public void setIdentificationName(String identificationName) {
        this.identificationName = identificationName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

	@JsonProperty("coordinate")
    public CoordinateDto getCoordinateDTO() {
        return coordinateDTO;
    }

    public void setCoordinateDTO(CoordinateDto coordinateDTO) {
        this.coordinateDTO = coordinateDTO;
    }

    public String getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public Integer getTruckPlaces() {
        return truckPlaces;
    }

    public void setTruckPlaces(Integer truckPlaces) {
        this.truckPlaces = truckPlaces;
    }

    public Integer getOccupiedTruckPlaces() {
        return occupiedTruckPlaces;
    }

    public void setOccupiedTruckPlaces(Integer occupiedTruckPlaces) {
        this.occupiedTruckPlaces = occupiedTruckPlaces;
    }

    public String getExtendedId() {
        return extendedId;
    }

    public void setExtendedId(String extendedId) {
        this.extendedId = extendedId;
    }

	@JsonProperty("extendedMopData")
    public ExtendedMopDataDto getExtendedMopDataDTO() {
        return extendedMopDataDTO;
    }

    public void setExtendedMopDataDTO(ExtendedMopDataDto extendedMopDataDTO) {
        this.extendedMopDataDTO = extendedMopDataDTO;
    }

    @Override
    public String toString() {
        return "MopDto{" +
                "id=" + id +
                ", identificationName='" + identificationName + '\'' +
                ", category='" + category + '\'' +
                ", place='" + place + '\'' +
                ", coordinateDTO=" + coordinateDTO +
                ", roadNumber='" + roadNumber + '\'' +
                ", truckPlaces=" + truckPlaces +
                ", occupiedTruckPlaces='" + occupiedTruckPlaces + '\'' +
                ", extendedId='" + extendedId + '\'' +
                ", extendedMopDataDTO=" + extendedMopDataDTO +
                '}';
    }
}
