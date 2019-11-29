package com.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectDetails {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	int projId;
	
	@Id
	String projectName;
	String clientName,technologies,startDate,endDate,city,country,priority,
			manager,projectDescription;
	
	ProjectDetails(){
		
	}
	public ProjectDetails(String clientName, String projectName, String technologies, String startDate, String endDate,
			String city, String country, String priority, String manager,String projectDescription) {
		this.clientName = clientName;
		this.projectName = projectName;
		this.technologies = technologies;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.country = country;
		this.priority = priority;
		this.manager = manager;
		this.projectDescription = projectDescription;
	}
	public ProjectDetails(int projId, String projectName, String clientName, String technologies, String startDate,
			String endDate, String city, String country, String priority, String manager, String projectDescription) {
		this.projId = projId;
		this.projectName = projectName;
		this.clientName = clientName;
		this.technologies = technologies;
		this.startDate = startDate;
		this.endDate = endDate;
		this.city = city;
		this.country = country;
		this.priority = priority;
		this.manager = manager;
		this.projectDescription = projectDescription;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getProjId() {
		return projId;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
}
