package com.ibm.project.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel

public class Tasks {
	
	String projectName,taskName,taskOwner,taskDetails;
	String startDate,endDate,status;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public Tasks() {
		
	}
	public Tasks(String projectName, String taskName, String taskOwner, String taskDetails, String startDate,
			String endDate,String status) {
		this.projectName = projectName;
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.taskDetails = taskDetails;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Tasks(String projectName, String taskName, String taskOwner, String taskDetails, String startDate,
			String endDate, String status, int id) {
		
		this.projectName = projectName;
		this.taskName = taskName;
		this.taskOwner = taskOwner;
		this.taskDetails = taskDetails;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskOwner() {
		return taskOwner;
	}
	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}
	public String getTaskDetails() {
		return taskDetails;
	}
	public void setTaskDetails(String taskDetails) {
		this.taskDetails = taskDetails;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
