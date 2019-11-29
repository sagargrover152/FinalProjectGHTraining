package com.ibm.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.project.bean.Tasks;
import com.ibm.project.service.TaskDetailsServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController

@Api(value = "Task Details" , description = "CONTAINS API FOR TaskDetails")


public class TaskDetailsController {
	
	@Autowired
	TaskDetailsServices services;
	
	@Autowired
	RestTemplate restTemp;
	
	@ApiOperation(value = "Get All Tasks" , notes = "hit this url to get allaaa tasks",response = List.class)
	@RequestMapping(method = RequestMethod.GET, value = "/tasks")
	Iterable<Tasks> getAllTasks(){
		return services.getAllTasks();
	}
	
	
	@ApiOperation(value = "Add Task" , notes = "hit this url to add task",response = List.class)
	@HystrixCommand(fallbackMethod = "CannotAddTask", commandProperties = {
			@HystrixProperty(name = "execution.timeout.enabled", value = "false") })
	@RequestMapping(method = RequestMethod.POST,value = "/tasks")
	String addTask(@RequestBody Tasks task) {
		services.addTask(task);
		restTemp.put("http://localhost:8086/chartChartingService/project",task);
		
		return "";
	}
	String CannotAddTask(Tasks task) {
	return "Cannot Add Task Currently.Sorry For The inconvenience.Please Try Again Later...";
		//return "Nothing";
	}

	
	@ApiOperation(value = "Get Tasks By Project Name" , notes = "hit this url to get task by project name",response = List.class)
	@RequestMapping(method = RequestMethod.GET, value = "/tasks/{projectName}")
	Iterable<Tasks> getTaskByProjectName(@PathVariable String projectName){
		return services.getTaskByProjectName(projectName);
	}
	
	
	@ApiOperation(value = "Update Task with Task Title" , notes = "hit this url to update task by task title",response = List.class)
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/{taskTitle}")
	void updateTaskWithTaskTitle(@RequestBody Tasks task,@PathVariable String taskTitle) {
		
		services.updateTaskWithTaskOwner(task,taskTitle);
	}
	
	
	@ApiOperation(value = "Update Task With Delete Employee" , notes = "hit this url to update task with delete employee",response = List.class)
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks")
	void updateTaskWithDeleteEmployee(@RequestBody String employeeName) {
		
		services.updateTaskWithDeleteEmployee(employeeName);
	}
	
	
	@ApiOperation(value = "Update Task Status" , notes = "hit this url to update task status",response = List.class)
	@HystrixCommand(fallbackMethod = "CannotUpdateTaskStatus",commandProperties = {
			@HystrixProperty(name = "execution.timeout.enabled", value = "false") })
	@RequestMapping(method = RequestMethod.PUT,value = "/tasks/status/{taskTitle}")
	String updateTaskStatus(@RequestBody Tasks task,@PathVariable String taskTitle) {
		
		
		restTemp.put("http://localhost:8086/chartChartingService/project/completetask", task);
		restTemp.put("http://localhost:8086/chartChartingService/emp_stat/completetask", task);
		services.updateTaskStatus(task,taskTitle);
		return "";
		
	}
	String CannotUpdateTaskStatus(Tasks task,String taskTitle) {
		return "Cannot Update Task Currently.Sorry For The inconvenience.Please Try Again Later...";
	}
	
	
	@ApiOperation(value = "Delete Task With Task Title" , notes = "hit this url to delete task with task title",response = List.class)
	@HystrixCommand(fallbackMethod = "CannotDeleteTask")
	@RequestMapping(method = RequestMethod.DELETE,value = "/tasks/{taskTitle}")
	String deleteTaskWithTaskOwner(@PathVariable String taskTitle) {
		String projectName=services.findProjectName(taskTitle);
		
		restTemp.delete("http://localhost:8086/chartChartingService/project/"+projectName);
		services.deleteTaskWithTaskOwner(taskTitle);
		return "";
	}
	String CannotDeleteTask(String taskTitle) {
		return "Cannot Delete Task Currently.Sorry For The inconvenience.Please Try Again Later...";
	}
	
}