package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="truck")
public class Truck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "registrition")
	@NotNull
	private String registrition;

	@Column(name = "brand")
	@NotNull
	private String brand;

	@Column(name = "model")
	@NotNull
	private String model;

	@Column(name = "car_year")
	@NotNull
	private Integer carYear;

	@OneToMany(mappedBy="truck")
	private List<TruckDriverWay> truckDriverWays = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Truck() {
	}

	public Truck(@NotNull String registrition, @NotNull String brand, @NotNull String model, @NotNull Integer carYear, List<TruckDriverWay> truckDriverWays, Company company) {
		this.registrition = registrition;
		this.brand = brand;
		this.model = model;
		this.carYear = carYear;
		this.truckDriverWays = truckDriverWays;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrition() {
		return registrition;
	}

	public void setRegistrition(String registrition) {
		this.registrition = registrition;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCarYear() {
		return carYear;
	}

	public void setCarYear(Integer carYear) {
		this.carYear = carYear;
	}

	public List<TruckDriverWay> getTruckDriverWays() {
		return truckDriverWays;
	}

	public void setTruckDriverWays(List<TruckDriverWay> truckDriverWays) {
		this.truckDriverWays = truckDriverWays;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Truck{" +
				"id=" + id +
				", registrition='" + registrition + '\'' +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", carYear=" + carYear +
				", truckDriverWays=" + truckDriverWays +
				", company=" + company +
				'}';
	}
}
