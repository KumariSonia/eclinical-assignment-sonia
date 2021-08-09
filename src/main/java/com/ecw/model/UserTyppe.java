package com.ecw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserTyppe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userTypeId;
	private String userType;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userType")
	private List<User> user;

	public int getUserTypeId() {
		return userTypeId;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserTyppe [userTypeId=" + userTypeId + ", userType=" + userType + "]";
	}

}
