package com.ibm.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.project.bean.Tasks;
import com.ibm.project.repo.TaskDetailsRepo;

@Service

public class TaskDetailsServices {
	
	@Autowired
	TaskDetailsRepo repo;

	public Iterable<Tasks> getAllTasks() {
		return repo.findAll();
		
	}

	public void addTask(Tasks task) {
		task.setStatus("");
		repo.save(task);
		
	}

	public Iterable<Tasks> getTaskByProjectName(String projectName) {
		return repo.findByProjectName(projectName);
		
	}

	public void updateTaskWithTaskOwner(Tasks tasks,String taskTitle) {
		String taskDetails=tasks.getTaskDetails();
		String endDate=tasks.getEndDate();
		String taskOwnr=tasks.getTaskOwner();
		repo.updateTaskWithTaskOwner(taskDetails,endDate,taskOwnr,taskTitle);
		
	}

	public void deleteTaskWithTaskOwner(String taskTitle) {
		repo.deleteTaskWithTaskOwner(taskTitle);
		
	}

	public void updateTaskStatus(Tasks task, String taskTitle) {
		// TODO Auto-generated method stub
		String taskStatus="Complete";
		repo.updateStatus(taskStatus,taskTitle);
	}

	public void updateTaskWithDeleteEmployee(String employeeName) {
		// TODO Auto-generated method stub
		repo.updateTaskWithDeleteEmployee(employeeName);
	}

	public String findProjectName(String taskTitle) {
		// TODO Auto-generated method stub
		return repo.findProjectName(taskTitle);
	}

}