package com.sitarski.truckparkserver.domain.dto;

import java.time.LocalDateTime;

public class TruckDriverWayDto {

    private Long id;

    private Double fuel;

    private Double distance;

    private LocalDateTime resultTime;

    private CoordinateDto coordinateDTO;

    private Long truckId;

    private Long driverId;

    public TruckDriverWayDto() {
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

    public LocalDateTime getResultTime() {
        return resultTime;
    }

    public void setResultTime(LocalDateTime resultTime) {
        this.resultTime = resultTime;
    }

    public CoordinateDto getCoordinateDTO() {
        return coordinateDTO;
    }

    public void setCoordinateDTO(CoordinateDto coordinateDTO) {
        this.coordinateDTO = coordinateDTO;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "TruckDriverWayDto{" +
                "id=" + id +
                ", fuel=" + fuel +
                ", distance=" + distance +
                ", resultTime=" + resultTime +
                ", coordinateDTO=" + coordinateDTO +
                ", truckId=" + truckId +
                ", driverId=" + driverId +
                '}';
    }
}
