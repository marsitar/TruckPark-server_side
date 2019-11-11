package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="extended_mop_data")
public class ExtendedMopData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "organization")
	@NotNull
	private String organization;

	@Column(name = "road_class")
	@NotNull
	private String roadClass;

	@Column(name = "passenger_places")
	@NotNull
	private Integer passengerPlaces;

	@Column(name = "coach_places")
	@NotNull
	private Integer coachPlaces;

	@Column(name = "is_guarded")
	@NotNull
	private Boolean isGuarded;

	@Column(name = "is_fenced")
	@NotNull
	private Boolean isFenced;

	@Column(name = "is_security_camera")
	@NotNull
	private Boolean isSecurityCamera;

	@Column(name = "is_petroleum")
	@NotNull
	private Boolean isPetroleum;

	@Column(name = "is_dangerous_cargo")
	@NotNull
	private Boolean isDangerousCargo;

	@Column(name = "is_restaurant")
	@NotNull
	private Boolean isRestaurant;

	@Column(name = "is_place_to_stay")
	@NotNull
	private Boolean isPlaceToStay;

	@Column(name = "is_toilet")
	@NotNull
	private Boolean isToilet;

	@Column(name = "is_carwash")
	@NotNull
	private Boolean isCarwash;

	@Column(name = "is_workshop")
	@NotNull
	private Boolean isWorkshop;

	@Column(name = "person_in_charge")
	@NotNull
	private String personInCharge;

	@Column(name = "person_in_charge_phone")
	@NotNull
	private String personInChargePhone;

	@Column(name = "person_in_charge_email")
	@NotNull
	private String personInChargeEmail;

	@OneToOne(mappedBy = "extendedMopData")
	private Mop mop;

	public ExtendedMopData() {
	}

	public ExtendedMopData(@NotNull String organization, @NotNull String roadClass, @NotNull Integer passengerPlaces, @NotNull Integer coachPlaces, @NotNull Boolean isGuarded, @NotNull Boolean isFenced, @NotNull Boolean isSecurityCamera, @NotNull Boolean isPetroleum, @NotNull Boolean isDangerousCargo, @NotNull Boolean isRestaurant, @NotNull Boolean isPlaceToStay, @NotNull Boolean isToilet, @NotNull Boolean isCarwash, @NotNull Boolean isWorkshop, @NotNull String personInCharge, @NotNull String personInChargePhone, @NotNull String personInChargeEmail, @NotNull Mop mop) {
		this.organization = organization;
		this.roadClass = roadClass;
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
		this.personInCharge = personInCharge;
		this.personInChargePhone = personInChargePhone;
		this.personInChargeEmail = personInChargeEmail;
		this.mop = mop;
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

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getPersonInChargePhone() {
		return personInChargePhone;
	}

	public void setPersonInChargePhone(String personInChargePhone) {
		this.personInChargePhone = personInChargePhone;
	}

	public String getPersonInChargeEmail() {
		return personInChargeEmail;
	}

	public void setPersonInChargeEmail(String personInChargeEmail) {
		this.personInChargeEmail = personInChargeEmail;
	}

	public Mop getMop() {
		return mop;
	}

	public void setMop(Mop mop) {
		this.mop = mop;
	}

	@Override
	public String toString() {
		return "ExtendedMopData{" +
				"id=" + id +
				", organization='" + organization + '\'' +
				", roadClass='" + roadClass + '\'' +
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
				", personInCharge='" + personInCharge + '\'' +
				", personInChargePhone='" + personInChargePhone + '\'' +
				", personInChargeEmail='" + personInChargeEmail + '\'' +
				", mop=" + mop +
				'}';
	}
}
