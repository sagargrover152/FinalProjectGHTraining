package com.ibm.training.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProjectStats {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer tracker_id;
	String project_name;
	Integer total_assigned_tasks;
	Integer completed_tasks;
	Integer month;
	Integer year;

	public Integer getTracker_id() {
		return tracker_id;
	}

	public void setTracker_id(Integer tracker_id) {
		this.tracker_id = tracker_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public Integer getTotal_assigned_tasks() {
		return total_assigned_tasks;
	}

	public void setTotal_assigned_tasks(Integer total_assigned_tasks) {
		this.total_assigned_tasks = total_assigned_tasks;
	}

	public Integer getCompleted_tasks() {
		return completed_tasks;
	}

	public void setCompleted_tasks(Integer completed_tasks) {
		this.completed_tasks = completed_tasks;
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

	public ProjectStats(Integer tracker_id, String project_name, Integer total_assigned_tasks, Integer completed_tasks,
			Integer month, Integer year) {
		this.tracker_id = tracker_id;
		this.project_name = project_name;
		this.total_assigned_tasks = total_assigned_tasks;
		this.completed_tasks = completed_tasks;
		this.month = month;
		this.year = year;
	}

	public ProjectStats() {
	}

}
