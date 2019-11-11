package com.sitarski.truckparkserver.domain.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TruckDriverWayDTO {

	private Long id;

	private Double fuel;

	private Double distance;

	private LocalDateTime dateTime;

	private CoordinateDTO coordinateDTO;

	private TruckDTO truckDTO;

	private DriverDTO driverDTO;

	public TruckDriverWayDTO() {
	}

	public TruckDriverWayDTO(Double fuel, Double distance, LocalDateTime dateTime, CoordinateDTO coordinateDTO, TruckDTO truckDTO, DriverDTO driverDTO) {
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

	public CoordinateDTO getCoordinateDTO() {
		return coordinateDTO;
	}

	public void setCoordinateDTO(CoordinateDTO coordinateDTO) {
		this.coordinateDTO = coordinateDTO;
	}

	public TruckDTO getTruckDTO() {
		return truckDTO;
	}

	public void setTruckDTO(TruckDTO truckDTO) {
		this.truckDTO = truckDTO;
	}

	public DriverDTO getDriverDTO() {
		return driverDTO;
	}

	public void setDriverDTO(DriverDTO driverDTO) {
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
