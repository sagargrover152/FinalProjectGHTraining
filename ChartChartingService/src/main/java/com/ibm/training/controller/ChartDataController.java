package com.ibm.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.training.model.EmployeeStats;
import com.ibm.training.model.ProjectDetails;
import com.ibm.training.model.ProjectStats;
import com.ibm.training.model.Tasks;
import com.ibm.training.service.MonthlyEmployeeStatsService;
import com.ibm.training.service.MonthlyProjectStatsService;




@CrossOrigin(origins = "http://localhost:*")
@RestController
public class ChartDataController {
	
	
	@Autowired
	RestTemplate restTemp;
	
	@Autowired
	MonthlyEmployeeStatsService e_service;
	
	@Autowired
	MonthlyProjectStatsService p_service;
	
	@RequestMapping("/employees")
	Iterable<EmployeeStats> getAllEmployees()
	{
		return e_service.getAllEmployees();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/emp_stat")
	void addEmpEntry(@RequestBody Tasks task) {
		e_service.addEmpEntry(task);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/emp_stat/completetask")
	void updateCompletedTaskInEmployeeStat(@RequestBody Tasks task) {
		e_service.updateCompletedTaskInEmployeeStat(task);
	}
	
	@RequestMapping("/employees/lastmonth/{month}/{year}/{project_name}")
	Iterable<EmployeeStats> getAllEmployeesForLastMonth(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name)
	{
		return e_service.getAllEmployeesForLastMonth(month, year, project_name);
	}
	
	@RequestMapping("/employees/{month}/{year}/{project_name}")
	Iterable<EmployeeStats> getAllEmployeesByMonth(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name)
	{
		return e_service.getAllEmployeesByMonth(month, year, project_name);
	}

	@RequestMapping("/projects/{month}/{year}/{project_name}")
	Iterable<ProjectStats> getAllMonthsBeforeCurrent(@PathVariable Integer month, @PathVariable Integer year, @PathVariable String project_name){
		return p_service.getAllMonthsBeforeCurrent(month, year, project_name);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	void addProjEntry(@RequestBody ProjectDetails project) {
		p_service.addProjEntry(project);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/project")
	void updateTotalTask(@RequestBody Tasks task) {
		p_service.updateTotalTask(task);
		restTemp.postForObject("http://localhost:8086/chartChartingService/emp_stat", task, String.class);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/project/completetask")
	void updateCompletedTask(@RequestBody Tasks task) {
		p_service.updateCompletedTask(task);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/project/{projectName}")
	void updateTotalTaskWithDeleteTask(@PathVariable String projectName) {
		p_service.updateTotalTaskWithDeleteTask(projectName);
	}
}
