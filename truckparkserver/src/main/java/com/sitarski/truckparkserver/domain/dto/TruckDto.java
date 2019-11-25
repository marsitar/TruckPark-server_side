package com.sitarski.truckparkserver.domain.dto;

public class TruckDto {

	private Long id;

	private String registration;

	private String brand;

	private String model;

	private Integer carYear;

	private TruckDriverWayDto truckDriverWayDTO;

	private CompanyDto companyDTO;

	public TruckDto() {
	}

	public TruckDto(String registration, String brand, String model, Integer carYear, TruckDriverWayDto truckDriverWayDTO, CompanyDto companyDTO) {
		this.registration = registration;
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

	public TruckDriverWayDto getTruckDriverWayDTO() {
		return truckDriverWayDTO;
	}

	public void setTruckDriverWayDTO(TruckDriverWayDto truckDriverWayDTO) {
		this.truckDriverWayDTO = truckDriverWayDTO;
	}

	public CompanyDto getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDto companyDTO) {
		this.companyDTO = companyDTO;
	}

	@Override
	public String toString() {
		return "TruckDto{" +
				"id=" + id +
				", registration='" + registration + '\'' +
				", brand='" + brand + '\'' +
				", model='" + model + '\'' +
				", carYear=" + carYear +
				", truckDriverWayDTO=" + truckDriverWayDTO +
				", companyDTO=" + companyDTO +
				'}';
	}
}
