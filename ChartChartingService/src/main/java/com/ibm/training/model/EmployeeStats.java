package com.ibm.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeStats {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer tracker_id;
	String emp_name;
	Integer project_part_progress;
	Integer month;
	Integer year;
	Integer total_task;
	Integer completed_task;
	String project_name;

	public EmployeeStats(Integer tracker_id, String emp_name, Integer project_part_progress,
			Integer month, Integer year,Integer total_task,Integer completed_task, String project_name) {
		this.tracker_id = tracker_id;
		this.emp_name = emp_name;
		this.project_part_progress = project_part_progress;
		this.month = month;
		this.year = year;
		this.project_name = project_name;
		this.completed_task=completed_task;
		this.total_task=total_task;
	}
	

	public Integer getTotal_task() {
		return total_task;
	}


	public void setTotal_task(Integer total_task) {
		this.total_task = total_task;
	}


	public Integer getCompleted_task() {
		return completed_task;
	}


	public void setCompleted_task(Integer completed_task) {
		this.completed_task = completed_task;
	}


	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Integer getTracker_id() {
		return tracker_id;
	}

	public void setTracker_id(Integer tracker_id) {
		this.tracker_id = tracker_id;
	}


	public Integer getProject_part_progress() {
		return project_part_progress;
	}

	public void setProject_part_progress(Integer project_part_progress) {
		this.project_part_progress = project_part_progress;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public EmployeeStats() {
	}

}
