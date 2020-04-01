package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "truck_driver_way")
public class TruckDriverWay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "fuel")
    private Double fuel;

    @NotNull
    @Column(name = "distance")
    private Double distance;

    @NotNull
    @Column(name = "result_time")
    private LocalDateTime resultTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_coordinate", referencedColumnName = "id")
    private Coordinate coordinate;

    @ManyToOne
    @JoinColumn(name = "id_truck", nullable = false)
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "id_driver", nullable = false)
    private Driver driver;

    public TruckDriverWay() {
    }

    public TruckDriverWay(@NotNull Double fuel, @NotNull Double distance, @NotNull LocalDateTime resultTime, Coordinate coordinate, Truck truck, Driver driver) {
        this.fuel = fuel;
        this.distance = distance;
        this.resultTime = resultTime;
        this.coordinate = coordinate;
        this.truck = truck;
        this.driver = driver;
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

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Driver getDriver() {
		return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "TruckDriverWay{" +
                "id=" + id +
                ", fuel=" + fuel +
                ", distance=" + distance +
                ", resultTime=" + resultTime +
                ", coordinate=" + coordinate +
                ", truck=" + truck +
                ", driver=" + driver +
                '}';
    }
}
