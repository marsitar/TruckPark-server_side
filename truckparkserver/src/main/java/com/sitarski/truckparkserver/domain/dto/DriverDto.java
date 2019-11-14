package com.sitarski.truckparkserver.domain.dto;

public class DriverDto {

	private Long id;

	private String fullName;

	private CompanyDto companyDTO;

	private TruckDriverWayDto truckDriverWayDTO;

	public DriverDto() {
	}

	public DriverDto(String fullName, CompanyDto companyDTO, TruckDriverWayDto truckDriverWayDTO) {
		this.fullName = fullName;
		this.companyDTO = companyDTO;
		this.truckDriverWayDTO = truckDriverWayDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public CompanyDto getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDto companyDTO) {
		this.companyDTO = companyDTO;
	}

	public TruckDriverWayDto getTruckDriverWayDTO() {
		return truckDriverWayDTO;
	}

	public void setTruckDriverWayDTO(TruckDriverWayDto truckDriverWayDTO) {
		this.truckDriverWayDTO = truckDriverWayDTO;
	}

	@Override
	public String toString() {
		return "DriverDTO{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", companyDTO=" + companyDTO +
				", truckDriverWayDTO=" + truckDriverWayDTO +
				'}';
	}
}
