package com.sitarski.truckparkserver.domain.dto;

import java.time.LocalDate;

public class TruckDTO {

	private Long id;

	private String registrition;

	private String brand;

	private String model;

	private Integer carYear;

	private TruckDriverWayDTO truckDriverWayDTO;

	private CompanyDTO companyDTO;

	public TruckDTO() {
	}

	public TruckDTO(String registrition, String brand, String model, Integer carYear, TruckDriverWayDTO truckDriverWayDTO, CompanyDTO companyDTO) {
		this.registrition = registrition;
		this.brand = brand;
		this.model = model;
		this.carYear = carYear;
		this.truckDriverWayDTO = truckDriverWayDTO;
		this.companyDTO = companyDTO;
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

	public TruckDriverWayDTO getTruckDriverWayDTO() {
		return truckDriverWayDTO;
	}

	public void setTruckDriverWayDTO(TruckDriverWayDTO truckDriverWayDTO) {
		this.truckDriverWayDTO = truckDriverWayDTO;
	}

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

	@Override
	public String toString() {
		return "TruckDTO{" +
				"id=" + id +
				", registrition='" + registrition + '\'' +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", carYear=" + carYear +
				", truckDriverWayDTO=" + truckDriverWayDTO +
				", companyDTO=" + companyDTO +
				'}';
	}
}
