package com.sitarski.truckparkserver.domain.dto;

public class ExtendedMopDataDTO {

	private Long id;

	private String organization;

	private String roadClass;

	private Integer passengerPlaces;

	private Integer coachPlaces;

	private Boolean isGuarded;

	private Boolean isFenced;

	private Boolean isSecurityCamera;

	private Boolean isPetroleum;

	private Boolean isDangerousCargo;

	private Boolean isRestaurant;

	private Boolean isPlaceToStay;

	private Boolean isToilet;

	private Boolean isCarwash;

	private Boolean isWorkshop;

	private String personInCharge;

	private String personInChargePhone;

	private String personInChargeEmail;

	private MopDTO mopDTO;

	public ExtendedMopDataDTO() {
	}

	public ExtendedMopDataDTO(String organization, String roadClass, Integer passengerPlaces, Integer coachPlaces, Boolean isGuarded, Boolean isFenced, Boolean isSecurityCamera, Boolean isPetroleum, Boolean isDangerousCargo, Boolean isRestaurant, Boolean isPlaceToStay, Boolean isToilet, Boolean isCarwash, Boolean isWorkshop, String personInCharge, String personInChargePhone, String personInChargeEmail, MopDTO mopDTO) {
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
		this.mopDTO = mopDTO;
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

	public MopDTO getMopDTO() {
		return mopDTO;
	}

	public void setMopDTO(MopDTO mopDTO) {
		this.mopDTO = mopDTO;
	}

	@Override
	public String toString() {
		return "ExtendedMopDataDTO{" +
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
				", mopDTO=" + mopDTO +
				'}';
	}
}
