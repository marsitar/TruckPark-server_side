package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "full_name", unique = true)
	private String fullName;

	@NotBlank
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Column(name = "surname")
	private String surname;

	@NotBlank
	@Column(name = "email")
	private String email;

	@NotBlank
	@Column(name = "phone_number")
	private String phoneNumber;

	@NotNull
	@Column(name = "hire_date")
	private LocalDate hireDate;

	@OneToOne()
	@JoinColumn(name="id_truck", nullable = false)
	private Truck truck;

	@NotNull
	@ManyToOne()
	@JoinColumn(name="id_company", nullable = false)
	private Company company;

	@NotNull
	@OneToMany(mappedBy="driver")
	private List<TruckDriverWay> truckDriverWays = new ArrayList<>();

	public Driver() {
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
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
}
