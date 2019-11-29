package com.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginDetails {

	@Id
	int id;
	String userName;
	String userPass;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
}
