package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "full_name")
	@NotNull
	private String fullName;

	@Column(name = "company_id")
	@NotNull
	@ManyToOne()
	@JoinColumn(name="id", nullable=false)
	private Company company;

	@NotNull
	@OneToMany(mappedBy="driver")
	private List<TruckDriverWay> truckDriverWays = new ArrayList<>();

	public Driver() {
	}

	public Driver(Long id, @NotNull String fullName, @NotNull Company company, @NotNull List<TruckDriverWay> truckDriverWays) {
		this.id = id;
		this.fullName = fullName;
		this.company = company;
		this.truckDriverWays = truckDriverWays;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<TruckDriverWay> getTruckDriverWays() {
		return truckDriverWays;
	}

	public void setTruckDriverWays(List<TruckDriverWay> truckDriverWays) {
		this.truckDriverWays = truckDriverWays;
	}

	@Override
	public String toString() {
		return "Driver{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", company=" + company +
				", truckDriverWays=" + truckDriverWays +
				'}';
	}
}
