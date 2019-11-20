package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mop")
public class Mop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "serial_number")
	@NotNull
	private Integer serialNumber;

	@Column(name = "place")
	@NotNull
	private String place;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coordinate_id", referencedColumnName = "id")
	private Coordinate coordinate;

	@Column(name = "road_number")
	@NotNull
	private String roadNumber;

	@Column(name = "truck_places")
	@NotNull
	private Integer truckPlaces;

	@Column(name = "occupied_truck_places")
	@NotNull
	private String occupiedTruckPlaces;

	@Column(name = "id_extended")
	@NotNull
	private String extendedId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_extended_mop_data", referencedColumnName = "id")
	private ExtendedMopData extendedMopData;

	public Mop() {
	}

	public Mop(@NotNull Integer serialNumber, @NotNull String place, Coordinate coordinate, @NotNull String roadNumber, @NotNull Integer truckPlaces, @NotNull String occupiedTruckPlaces, @NotNull String extendedId, ExtendedMopData extendedMopData) {
		this.serialNumber = serialNumber;
		this.place = place;
		this.coordinate = coordinate;
		this.roadNumber = roadNumber;
		this.truckPlaces = truckPlaces;
		this.occupiedTruckPlaces = occupiedTruckPlaces;
		this.extendedId = extendedId;
		this.extendedMopData = extendedMopData;
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

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
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

	public ExtendedMopData getExtendedMopData() {
		return extendedMopData;
	}

	public void setExtendedMopData(ExtendedMopData extendedMopData) {
		this.extendedMopData = extendedMopData;
	}

	@Override
	public String toString() {
		return "Mop{" +
				"id=" + id +
				", serialNumber=" + serialNumber +
				", place='" + place + '\'' +
				", coordinate=" + coordinate +
				", roadNumber='" + roadNumber + '\'' +
				", truckPlaces=" + truckPlaces +
				", occupiedTruckPlaces='" + occupiedTruckPlaces + '\'' +
				", extendedId='" + extendedId + '\'' +
				", extendedMopData=" + extendedMopData +
				'}';
	}
}
