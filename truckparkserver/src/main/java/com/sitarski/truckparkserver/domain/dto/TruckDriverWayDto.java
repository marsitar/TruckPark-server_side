package com.sitarski.truckparkserver.domain.dto;

import java.time.LocalDateTime;

public class TruckDriverWayDto {

	private Long id;

	private Double fuel;

	private Double distance;

	private LocalDateTime dateTime;

	private CoordinateDto coordinateDTO;

	private TruckDto truckDTO;

	private DriverDto driverDTO;

	public TruckDriverWayDto() {
	}

	public TruckDriverWayDto(Double fuel, Double distance, LocalDateTime dateTime, CoordinateDto coordinateDTO, TruckDto truckDTO, DriverDto driverDTO) {
		this.fuel = fuel;
		this.distance = distance;
		this.dateTime = dateTime;
		this.coordinateDTO = coordinateDTO;
		this.truckDTO = truckDTO;
		this.driverDTO = driverDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getFuel() {
		return fuel;
	}

	public void setFuel(Double fuel) {
		this.fuel = fuel;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public CoordinateDto getCoordinateDTO() {
		return coordinateDTO;
	}

	public void setCoordinateDTO(CoordinateDto coordinateDTO) {
		this.coordinateDTO = coordinateDTO;
	}

	public TruckDto getTruckDTO() {
		return truckDTO;
	}

	public void setTruckDTO(TruckDto truckDTO) {
		this.truckDTO = truckDTO;
	}

	public DriverDto getDriverDTO() {
		return driverDTO;
	}

	public void setDriverDTO(DriverDto driverDTO) {
		this.driverDTO = driverDTO;
	}

	@Override
	public String toString() {
		return "TruckDriverWayDTO{" +
				"id=" + id +
				", fuel=" + fuel +
				", distance=" + distance +
				", dateTime=" + dateTime +
				", coordinateDTO=" + coordinateDTO +
				", truckDTO=" + truckDTO +
				", driverDTO=" + driverDTO +
				'}';
	}
}
