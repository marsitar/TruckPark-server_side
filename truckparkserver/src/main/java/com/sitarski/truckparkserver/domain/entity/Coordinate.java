package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="coordinate")
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "x")
	@NotNull
	private Double x;

	@Column(name = "y")
	@NotNull
	private Double y;

	public Coordinate() {
	}

	public Coordinate(@NotNull Double x, @NotNull Double y) {
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
		return "Coordinate{" +
				"id=" + id +
				", x=" + x +
				", y=" + y +
				'}';
	}
}
