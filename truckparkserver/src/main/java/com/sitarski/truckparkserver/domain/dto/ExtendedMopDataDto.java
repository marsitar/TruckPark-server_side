package com.sitarski.truckparkserver.domain.dto;

public class ExtendedMopDataDto {

    private Long id;

    private String organization;

    private String roadClass;

    private String direction;

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

    private Boolean isLighting;

    private Boolean isElectricCharger;

    private String organizationInCharge;

    private String organizationInChargePhone;

    private String organizationInChargeEmail;

    public ExtendedMopDataDto() {
    }

    public ExtendedMopDataDto(Long id, String organization, String roadClass, String direction, Integer passengerPlaces, Integer coachPlaces, Boolean isGuarded, Boolean isFenced, Boolean isSecurityCamera, Boolean isPetroleum, Boolean isDangerousCargo, Boolean isRestaurant, Boolean isPlaceToStay, Boolean isToilet, Boolean isCarwash, Boolean isWorkshop, Boolean isLighting, Boolean isElectricCharger, String organizationInCharge, String organizationInChargePhone, String organizationInChargeEmail) {
        this.id = id;
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

    public Boolean getLighting() {
        return isLighting;
    }

    public void setLighting(Boolean lighting) {
        isLighting = lighting;
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
        return "ExtendedMopDataDto{" +
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
                ", isLighting=" + isLighting +
                ", isElectricCharger=" + isElectricCharger +
                ", organizationInCharge='" + organizationInCharge + '\'' +
                ", organizationInChargePhone='" + organizationInChargePhone + '\'' +
                ", organizationInChargeEmail='" + organizationInChargeEmail + '\'' +
                '}';
    }
}
