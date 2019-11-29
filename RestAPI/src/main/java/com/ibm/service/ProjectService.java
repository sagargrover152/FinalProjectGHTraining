package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bean.EmployeeDetails;
import com.ibm.bean.ProjectDetails;
import com.ibm.repository.UserRepositoryEmployee;
import com.ibm.repository.UserRepositoryProject;

@Service
public class ProjectService {
	
	@Autowired
	UserRepositoryProject projRepo;

	public List<String> findAllProject(String str) {
		return projRepo.findAllProject(str);
	}

	public void save(ProjectDetails project) {
		// TODO Auto-generated method stub
		projRepo.save(project);
	}
	
	public Iterable<ProjectDetails> findAllProjects() {
		return projRepo.findAll();
	}

	public void updateProject(ProjectDetails proj, String givenName) {
		String clientName = proj.getClientName();
		String projectName = proj.getProjectName();
		String startDate = proj.getStartDate();
		String endDate = proj.getEndDate();
		String city = proj.getCity();
		String country = proj.getCountry();
		String technologies = proj.getTechnologies();
		String priority = proj.getPriority();
		String manager= proj.getManager();
		String projectDescription = proj.getProjectDescription();
		projRepo.updatebyname(clientName,projectName,startDate,endDate,city,
				country,technologies,priority,givenName,projectDescription,manager);
		
	}

	public ProjectDetails getProjectDetails(String projectName) {
		// TODO Auto-generated method stub
		return projRepo.findByProjectName(projectName);
	}

	public void delProject(String projectName) {
		// TODO Auto-generated method stub
		projRepo.deleteByName(projectName);
	}
	
	
}
