package com.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ManagerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int empId;
	String fullName,Availability,email,phoneNumber,projectAssigned;
	public String getProjectAssigned() {
		return projectAssigned;
	}
	public ManagerDetails() {
		// TODO Auto-generated constructor stub
	}
	public String getAvailability() {
		return Availability;
	}
	public void setAvailability(String availability) {
		Availability = availability;
	}
	public void setProjectAssigned(String projectAssigned) {
		this.projectAssigned = projectAssigned;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
}
