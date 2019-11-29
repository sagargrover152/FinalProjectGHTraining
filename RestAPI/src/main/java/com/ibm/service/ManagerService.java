package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ibm.bean.EmployeeDetails;
import com.ibm.bean.ManagerDetails;
import com.ibm.bean.ProjectDetails;
import com.ibm.repository.UserRepositoryManager;

@Service
public class ManagerService {

	@Autowired
	UserRepositoryManager managerRepo;
	
	public Iterable<ManagerDetails> findAllManagers() {
		return managerRepo.findAll();
	}

	public Iterable<String> findAllManagersAvailable() {
		// TODO Auto-generated method stub
		return managerRepo.findAllManagersAvailable();
	}

	public void updateManagerWithProjectCreation(ProjectDetails project, String managerName) {
		// TODO Auto-generated method stub
		managerRepo.updateManagerWithProjectCreation(project.getProjectName(),managerName);
	}

	public void updateManagerWithProjectEdit(String projectName) {
		// TODO Auto-generated method stub
		managerRepo.updateManagerWithProjectEdit(projectName);
	}
}
