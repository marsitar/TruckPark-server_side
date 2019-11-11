package com.sitarski.truckparkserver.domain.dto;

public class CoordinateDTO {

	private Long id;

	private Double x;

	private Double y;

	public CoordinateDTO() {
	}

	public CoordinateDTO(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "CoordinateDTO{" +
				"id=" + id +
				", x=" + x +
				", y=" + y +
				'}';
	}
}
