package com.registration.login.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(columnDefinition = "Number(10) default '1'")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "failed_tries", columnDefinition = " integer default 0 ")
	private int failedTries;

	@Column(name = "locked", columnDefinition = " integer default 0 ")
	private int isLocked;

	public UserDetails() {

	}

	public UserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFailedTries() {
		return failedTries;
	}

	public void setFailedTries(int failedTries) {
		this.failedTries = failedTries;
	}

	public int getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(int isLocked) {
		this.isLocked = isLocked;
	}

	@Override
	public String toString() {
		return String.format("UserDetails [id=%s, username=%s, password=%s, failedTries=%s, isLocked=%s]", id, username,
				password, failedTries, isLocked);
	}
}
