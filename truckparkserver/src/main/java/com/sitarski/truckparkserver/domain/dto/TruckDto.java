package com.sitarski.truckparkserver.domain.dto;

public class TruckDto {

	private Long id;
	private String registration;
	private String brand;
	private String model;
	private Integer carYear;
	private Long companyId;

	public TruckDto() {
	}

	public TruckDto(Long id, String registration, String brand, String model, Integer carYear, Long companyId) {
		this.id = id;
		this.registration = registration;
		this.brand = brand;
		this.model = model;
		this.carYear = carYear;
		this.companyId = companyId;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "TruckDto{" +
				"id=" + id +
				", registration='" + registration + '\'' +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", carYear=" + carYear +
				", companyId=" + companyId +
				'}';
	}
}
