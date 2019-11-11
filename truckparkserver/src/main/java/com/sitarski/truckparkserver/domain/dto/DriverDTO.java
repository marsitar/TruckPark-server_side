package com.sitarski.truckparkserver.domain.dto;

public class DriverDTO {

	private Long id;

	private String fullName;

	private CompanyDTO companyDTO;

	private TruckDriverWayDTO truckDriverWayDTO;

	public DriverDTO() {
	}

	public DriverDTO(String fullName, CompanyDTO companyDTO, TruckDriverWayDTO truckDriverWayDTO) {
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

	public CompanyDTO getCompanyDTO() {
		return companyDTO;
	}

	public void setCompanyDTO(CompanyDTO companyDTO) {
		this.companyDTO = companyDTO;
	}

	public TruckDriverWayDTO getTruckDriverWayDTO() {
		return truckDriverWayDTO;
	}

	public void setTruckDriverWayDTO(TruckDriverWayDTO truckDriverWayDTO) {
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
