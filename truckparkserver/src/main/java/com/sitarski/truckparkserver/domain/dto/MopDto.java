package com.sitarski.truckparkserver.domain.dto;

public class MopDto {

	private Long id;

	private Integer serialNumber;

	private String place;

	private CoordinateDto coordinateDTO;

	private String roadNumber;

	private Integer truckPlaces;

	private String occupiedTruckPlaces;

	private String extendedId;

	private ExtendedMopDataDto extendedMopDataDTO;

	public MopDto() {
	}

	public MopDto(Integer serialNumber, String place, CoordinateDto coordinateDTO, String roadNumber, Integer truckPlaces, String occupiedTruckPlaces, String extendedId, ExtendedMopDataDto extendedMopDataDTO) {
		this.serialNumber = serialNumber;
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

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

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

	public String getOccupiedTruckPlaces() {
		return occupiedTruckPlaces;
	}

	public void setOccupiedTruckPlaces(String occupiedTruckPlaces) {
		this.occupiedTruckPlaces = occupiedTruckPlaces;
	}

	public String getExtendedId() {
		return extendedId;
	}

	public void setExtendedId(String extendedId) {
		this.extendedId = extendedId;
	}

	public ExtendedMopDataDto getExtendedMopDataDTO() {
		return extendedMopDataDTO;
	}

	public void setExtendedMopDataDTO(ExtendedMopDataDto extendedMopDataDTO) {
		this.extendedMopDataDTO = extendedMopDataDTO;
	}

	@Override
	public String toString() {
		return "MopDTO{" +
				"id=" + id +
				", serialNumber=" + serialNumber +
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
