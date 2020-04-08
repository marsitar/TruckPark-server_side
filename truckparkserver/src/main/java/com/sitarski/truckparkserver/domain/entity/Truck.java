package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="truck")
public class Truck {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "registration")
	private String registration;

	@NotBlank
	@Column(name = "brand")
	private String brand;

	@NotBlank
	@Column(name = "model")
	private String model;

	@NotNull
	@Min(1980)
	@Column(name = "car_year")
	private Integer carYear;

	@OneToMany(mappedBy="truck")
	private List<TruckDriverWay> truckDriverWays = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;

	public Truck() {
	}

	public Truck(@NotNull String registration, @NotNull String brand, @NotNull String model, @NotNull Integer carYear, List<TruckDriverWay> truckDriverWays, Company company) {
		this.registration = registration;
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

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
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
				", registrition='" + registration + '\'' +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", carYear=" + carYear +
				", truckDriverWays=" + truckDriverWays +
				", company=" + company +
				'}';
	}
}
