package com.ibm.training.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.training.model.ProjectStats;

@Repository
public interface MonthlyProjectStatsRepository extends CrudRepository<ProjectStats, Integer> {
	
	@Query(value = "select * from project_stats where month<:month and month>((:month)-6) and year=:year and project_name=:project_name order by month desc", nativeQuery = true)
	Iterable<ProjectStats> findAllProjectsBeforeMonth(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "project_name") String project_name);

	@Modifying
	@Transactional
	@Query(value = "update project_stats set total_assigned_tasks=:totalTask where project_name=:projectName",nativeQuery = true)
	void updateTotalTask(@Param(value = "projectName")String projectName, @Param(value = "totalTask")int totalTask);

	@Query(value = "select total_assigned_tasks from project_stats where project_name=:projectName",nativeQuery = true)
	Integer getTotalTask(@Param(value = "projectName")String projectName);

	@Query(value = "select completed_tasks from project_stats where project_name=:projectName",nativeQuery = true)
	Integer getCompletedTask(@Param(value = "projectName") String projectName);

	@Modifying
	@Transactional
	@Query(value = "update project_stats set completed_tasks=:completedTask where project_name=:projectName",nativeQuery = true)
	void updateCompletedTask(String projectName, @Param(value = "completedTask")int CompletedTask);

}
