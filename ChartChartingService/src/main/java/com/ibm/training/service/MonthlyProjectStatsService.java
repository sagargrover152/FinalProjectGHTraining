package com.ibm.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.model.ProjectDetails;
import com.ibm.training.model.ProjectStats;
import com.ibm.training.model.Tasks;
import com.ibm.training.repository.MonthlyProjectStatsRepository;

@Service
public class MonthlyProjectStatsService {
	
	@Autowired
	MonthlyProjectStatsRepository repo;
	
	
	
	
	public Iterable<ProjectStats> getAllMonthsBeforeCurrent(Integer month, Integer year, String project_name){
		return repo.findAllProjectsBeforeMonth(month, year, project_name);
	}

	public void addProjEntry(ProjectDetails project) {
		// TODO Auto-generated method stub
		ProjectStats ProjectStats = new ProjectStats();
		ProjectStats.setProject_name(project.getProjectName());
		ProjectStats.setTotal_assigned_tasks(0);
		ProjectStats.setCompleted_tasks(0);
		String date=project.getStartDate();
		String[] dateData = new String[3];
		dateData=date.split("-");
	
		ProjectStats.setMonth(Integer.parseInt(dateData[1]));
		ProjectStats.setYear(Integer.parseInt(dateData[0]));
		repo.save(ProjectStats);
	}

	public void updateTotalTask(Tasks task) {
		// TODO Auto-generated method stub
		Integer totalTask = repo.getTotalTask(task.getProjectName());
		repo.updateTotalTask(task.getProjectName(),totalTask+1);
	}

	public void updateCompletedTask(Tasks task) {
		// TODO Auto-generated method stub
		Integer completedTask = repo.getCompletedTask(task.getProjectName());
		repo.updateCompletedTask(task.getProjectName(),completedTask+1);
	}

	public void updateTotalTaskWithDeleteTask(String projectName) {
		// TODO Auto-generated method stub
		repo.updateTotalTask(projectName, repo.getTotalTask(projectName)-1);
	}

}
