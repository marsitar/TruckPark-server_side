package com.sitarski.truckparkserver.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user_system")
public class UserSystem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "login")
	@NotNull
	private String login;

	@Column(name = "email_adress")
	@NotNull
	private String emailAdress;

	@Column(name = "system_role")
	@NotNull
	private String systemRole;

	public UserSystem() {
	}

	public UserSystem(@NotNull String login, @NotNull String emailAdress, @NotNull String systemRole) {
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
		return "UserSystem{" +
				"id=" + id +
				", login='" + login + '\'' +
				", emailAdress='" + emailAdress + '\'' +
				", systemRole='" + systemRole + '\'' +
				'}';
	}
}
