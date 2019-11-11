package com.sitarski.truckparkserver.domain.dto;

public class CompanyDTO {

	private Long id;

	private String fullName;

	public CompanyDTO() {
	}

	public CompanyDTO(String fullName) {
		this.fullName = fullName;
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

	@Override
	public String toString() {
		return "Company{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				'}';
	}

}
