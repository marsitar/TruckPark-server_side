package com.sitarski.truckparkserver.domain.dto;

public class UserSystemDto {

	private Long id;

	private String login;

	private String emailAdress;

	private String systemRole;

	public UserSystemDto() {
	}

	public UserSystemDto(String login, String emailAdress, String systemRole) {
		this.login = login;
		this.emailAdress = emailAdress;
		this.systemRole = systemRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}

	@Override
	public String toString() {
		return "UserSystemDTO{" +
				"id=" + id +
				", login='" + login + '\'' +
				", emailAdress='" + emailAdress + '\'' +
				", systemRole='" + systemRole + '\'' +
				'}';
	}
}
