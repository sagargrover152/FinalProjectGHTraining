package com.ibm.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.model.EmployeeDetails;
import com.ibm.training.model.EmployeeStats;
import com.ibm.training.model.Tasks;
import com.ibm.training.repository.MonthlyEmployeeStatsRepository;

@Service
public class MonthlyEmployeeStatsService {
	
	@Autowired
	MonthlyEmployeeStatsRepository repo;
	
	

	public Iterable<EmployeeStats> getAllEmployees() {
		
		return repo.findAll();
	}

	public Iterable<EmployeeStats> getAllEmployeesForLastMonth(Integer month, Integer year, String project_name) {
		return repo.findByMonth(month, year, project_name);
	}

	public Iterable<EmployeeStats> getAllEmployeesByMonth(Integer month,  Integer year, String project_name) {
		return repo.findAllMonthsBeforeCurrent(month, year, project_name);
	}

	public void addEmpEntry(Tasks task) {
		EmployeeStats empStat=new EmployeeStats();
		// TODO Auto-generated method stub
		empStat.setEmp_name(task.getTaskOwner());
		empStat.setProject_name(task.getProjectName());
		String date=task.getStartDate();
		String[] dateData = new String[3];
		dateData=date.split("-");
		empStat.setMonth(Integer.parseInt(dateData[1]));
		empStat.setYear(Integer.parseInt(dateData[0]));
		Integer exist=repo.checkEntry(empStat.getMonth(),empStat.getYear(),empStat.getEmp_name(),empStat.getProject_name());
		if(exist==0) {
			empStat.setProject_part_progress(0);
			empStat.setTotal_task(1);
			empStat.setCompleted_task(0);
			repo.save(empStat);
		}
		else
		{
			empStat.setCompleted_task(repo.getCompletedTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName()));
			empStat.setTotal_task(repo.getTotalTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName())+1);
			empStat.setProject_part_progress((repo.getCompletedTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName())*100)/(repo.getTotalTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName())+1));
			repo.updateEntryForTotalTask(empStat.getMonth(),empStat.getYear(),empStat.getEmp_name(),empStat.getTotal_task(),empStat.getProject_part_progress(),task.getProjectName());
		}
		
		
	}

	public void updateCompletedTaskInEmployeeStat(Tasks task) {
		// TODO Auto-generated method stub
		String date=task.getStartDate();
		String[] dateData = new String[3];
		dateData=date.split("-");
		Integer progress = ((repo.getCompletedTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName())+1)*100)/repo.getTotalTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName());
		repo.updateEntryForCompletedTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName(),repo.getCompletedTask(Integer.parseInt(dateData[1]),Integer.parseInt(dateData[0]),task.getTaskOwner(),task.getProjectName())+1,progress);
	}	

}
