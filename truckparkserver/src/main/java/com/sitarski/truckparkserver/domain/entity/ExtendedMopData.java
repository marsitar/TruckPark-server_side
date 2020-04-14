package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="extended_mop_data")
public class ExtendedMopData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(name = "organization")
	private String organization;

	@NotBlank
	@Column(name = "road_class")
	private String roadClass;

	@NotBlank
	@Column(name = "direction")
	private String direction;

	@NotNull
	@Column(name = "passenger_places")
	private Integer passengerPlaces;

	@NotNull
	@Column(name = "coach_places")
	private Integer coachPlaces;

	@NotNull
	@Column(name = "is_guarded")
	private Boolean isGuarded;

	@NotNull
	@Column(name = "is_fenced")
	private Boolean isFenced;

	@NotNull
	@Column(name = "is_security_camera")
	private Boolean isSecurityCamera;

	@NotNull
	@Column(name = "is_petroleum")
	private Boolean isPetroleum;

	@NotNull
	@Column(name = "is_dangerous_cargo")
	private Boolean isDangerousCargo;

	@NotNull
	@Column(name = "is_restaurant")
	private Boolean isRestaurant;

	@NotNull
	@Column(name = "is_place_to_stay")
	private Boolean isPlaceToStay;

	@NotNull
	@Column(name = "is_toilet")
	private Boolean isToilet;

	@NotNull
	@Column(name = "is_carwash")
	private Boolean isCarwash;

	@NotNull
	@Column(name = "is_workshop")
	private Boolean isWorkshop;

	@NotNull
	@Column(name = "is_lighting")
	private Boolean isLighting;

	@NotNull
	@Column(name = "is_electric_charger")
	private Boolean isElectricCharger;

	@NotBlank
	@Column(name = "organization_in_charge")
	private String organizationInCharge;

	@NotBlank
	@Column(name = "organization_in_charge_phone")
	private String organizationInChargePhone;

	@NotBlank
	@Column(name = "organization_in_charge_email")
	private String organizationInChargeEmail;

	public ExtendedMopData() {
	}

	public ExtendedMopData(@NotNull String organization, @NotNull String roadClass, @NotNull String direction, @NotNull Integer passengerPlaces, @NotNull Integer coachPlaces, @NotNull Boolean isGuarded, @NotNull Boolean isFenced, @NotNull Boolean isSecurityCamera, @NotNull Boolean isPetroleum, @NotNull Boolean isDangerousCargo, @NotNull Boolean isRestaurant, @NotNull Boolean isPlaceToStay, @NotNull Boolean isToilet, @NotNull Boolean isCarwash, @NotNull Boolean isWorkshop, @NotNull Boolean isLighting, @NotNull Boolean isElectricCharger, @NotNull String organizationInCharge, @NotNull String organizationInChargePhone, @NotNull String organizationInChargeEmail) {
		this.organization = organization;
		this.roadClass = roadClass;
		this.direction = direction;
		this.passengerPlaces = passengerPlaces;
		this.coachPlaces = coachPlaces;
		this.isGuarded = isGuarded;
		this.isFenced = isFenced;
		this.isSecurityCamera = isSecurityCamera;
		this.isPetroleum = isPetroleum;
		this.isDangerousCargo = isDangerousCargo;
		this.isRestaurant = isRestaurant;
		this.isPlaceToStay = isPlaceToStay;
		this.isToilet = isToilet;
		this.isCarwash = isCarwash;
		this.isWorkshop = isWorkshop;
		this.isLighting = isLighting;
		this.isElectricCharger = isElectricCharger;
		this.organizationInCharge = organizationInCharge;
		this.organizationInChargePhone = organizationInChargePhone;
		this.organizationInChargeEmail = organizationInChargeEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRoadClass() {
		return roadClass;
	}

	public void setRoadClass(String roadClass) {
		this.roadClass = roadClass;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Boolean getLighting() {
		return isLighting;
	}

	public void setLighting(Boolean lighting) {
		isLighting = lighting;
	}

	public Integer getPassengerPlaces() {
		return passengerPlaces;
	}

	public void setPassengerPlaces(Integer passengerPlaces) {
		this.passengerPlaces = passengerPlaces;
	}

	public Integer getCoachPlaces() {
		return coachPlaces;
	}

	public void setCoachPlaces(Integer coachPlaces) {
		this.coachPlaces = coachPlaces;
	}

	public Boolean getGuarded() {
		return isGuarded;
	}

	public void setGuarded(Boolean guarded) {
		isGuarded = guarded;
	}

	public Boolean getFenced() {
		return isFenced;
	}

	public void setFenced(Boolean fenced) {
		isFenced = fenced;
	}

	public Boolean getSecurityCamera() {
		return isSecurityCamera;
	}

	public void setSecurityCamera(Boolean securityCamera) {
		isSecurityCamera = securityCamera;
	}

	public Boolean getPetroleum() {
		return isPetroleum;
	}

	public void setPetroleum(Boolean petroleum) {
		isPetroleum = petroleum;
	}

	public Boolean getDangerousCargo() {
		return isDangerousCargo;
	}

	public void setDangerousCargo(Boolean dangerousCargo) {
		isDangerousCargo = dangerousCargo;
	}

	public Boolean getRestaurant() {
		return isRestaurant;
	}

	public void setRestaurant(Boolean restaurant) {
		isRestaurant = restaurant;
	}

	public Boolean getPlaceToStay() {
		return isPlaceToStay;
	}

	public void setPlaceToStay(Boolean placeToStay) {
		isPlaceToStay = placeToStay;
	}

	public Boolean getToilet() {
		return isToilet;
	}

	public void setToilet(Boolean toilet) {
		isToilet = toilet;
	}

	public Boolean getCarwash() {
		return isCarwash;
	}

	public void setCarwash(Boolean carwash) {
		isCarwash = carwash;
	}

	public Boolean getWorkshop() {
		return isWorkshop;
	}

	public void setWorkshop(Boolean workshop) {
		isWorkshop = workshop;
	}

	public Boolean getElectricCharger() {
		return isElectricCharger;
	}

	public void setElectricCharger(Boolean electricCharger) {
		isElectricCharger = electricCharger;
	}

	public String getOrganizationInCharge() {
		return organizationInCharge;
	}

	public void setOrganizationInCharge(String organizationInCharge) {
		this.organizationInCharge = organizationInCharge;
	}

	public String getOrganizationInChargePhone() {
		return organizationInChargePhone;
	}

	public void setOrganizationInChargePhone(String organizationInChargePhone) {
		this.organizationInChargePhone = organizationInChargePhone;
	}

	public String getOrganizationInChargeEmail() {
		return organizationInChargeEmail;
	}

	public void setOrganizationInChargeEmail(String organizationInChargeEmail) {
		this.organizationInChargeEmail = organizationInChargeEmail;
	}

	@Override
	public String toString() {
		return "ExtendedMopData{" +
				"id=" + id +
				", organization='" + organization + '\'' +
				", roadClass='" + roadClass + '\'' +
				", direction='" + direction + '\'' +
				", passengerPlaces=" + passengerPlaces +
				", coachPlaces=" + coachPlaces +
				", isGuarded=" + isGuarded +
				", isFenced=" + isFenced +
				", isSecurityCamera=" + isSecurityCamera +
				", isPetroleum=" + isPetroleum +
				", isDangerousCargo=" + isDangerousCargo +
				", isRestaurant=" + isRestaurant +
				", isPlaceToStay=" + isPlaceToStay +
				", isToilet=" + isToilet +
				", isCarwash=" + isCarwash +
				", isWorkshop=" + isWorkshop +
				", isLighting=" + isLighting +
				", isElectricCharger=" + isElectricCharger +
				", organizationInCharge='" + organizationInCharge + '\'' +
				", organizationInChargePhone='" + organizationInChargePhone + '\'' +
				", organizationInChargeEmail='" + organizationInChargeEmail + '\'' +
				'}';
	}
}
