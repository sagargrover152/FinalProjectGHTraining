package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bean.EmployeeDetails;
import com.ibm.repository.UserRepositoryEmployee;

@Service
public class EmployeeService {

	@Autowired
	UserRepositoryEmployee empRepo;
	
	
	public void save(EmployeeDetails employee) {
		employee.setFullName(employee.getFirstName()+" "+employee.getLastName());
		employee.setAvailability(" ");
		employee.setProjectAssigned(" ");
		empRepo.save(employee);
		empRepo.setDefault(employee.getFullName());
	}

	public Iterable<EmployeeDetails> findAllEmployees() {
		return empRepo.findAll();
	}

	public void updateEmployee(EmployeeDetails employee, String employeeName) {
		// TODO Auto-generated method stub
		String email = employee.getEmail();
		String designation = employee.getDesignation();
		String phoneNumber = employee.getPhoneNumber();
		String technologies = employee.getTechnologies();
		empRepo.updateEmployeeByName(email,designation,phoneNumber,technologies,employeeName);
	}

	public void delEmployee(String employeeName) {
		// TODO Auto-generated method stub
		empRepo.deleteByName(employeeName);
	}

	public void assignProject(EmployeeDetails employee, String projectName) {
		// TODO Auto-generated method stub
		String empName=employee.getFirstName()+" "+employee.getLastName();
		empRepo.assignProject(empName,projectName);
	}

	public Iterable<EmployeeDetails> getAvailableEmployees() {
		// TODO Auto-generated method stub
		return empRepo.getAvailableEmployees();
	}

	public Iterable<EmployeeDetails> findAllEmployeesInProject(String projectName) {
		// TODO Auto-generated method stub
		return empRepo.findAllEmployeesInProject(projectName);
	}

	public void unAssignProject(EmployeeDetails employee, String empName) {
		// TODO Auto-generated method stub
		empRepo.setDefault(empName);
	}

	public void resetEmployeeWithDeleteProject(String projectName) {
		// TODO Auto-generated method stub
		empRepo.resetEmployeeWithDeleteProject(projectName);
	}

	public List<String> getEmployeesOnProject(String projectName) {
		// TODO Auto-generated method stub
		return empRepo.getEmployeesOnProject(projectName);
	}

}
