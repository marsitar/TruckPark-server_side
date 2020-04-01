package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="coordinate")
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "id_seq")
	@SequenceGenerator(name = "id_seq",
			sequenceName = "COORDINATE_SEQ",allocationSize=1)
	@Column(name = "id")
	private Long id;

	@Column(name = "lat")
	@NotNull
	private Double lat;

	@Column(name = "lng")
	@NotNull
	private Double lng;

	public Coordinate() {
	}

	public Coordinate(@NotNull Double lat, @NotNull Double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "Coordinate{" +
				"id=" + id +
				", lat=" + lat +
				", lng=" + lng +
				'}';
	}
}
