package com.ibm.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.training.model.EmployeeStats;



@Repository
public interface MonthlyEmployeeStatsRepository extends CrudRepository<EmployeeStats, Integer>{

	@Query(value = "select * from employee_stats where month=:month and year=:year and project_name=:project_name" ,nativeQuery = true)
	Iterable<EmployeeStats> findByMonth(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "project_name") String project_name);

	@Query(value = "select * from employee_stats where month<:month and month>((:month)-6) and year=:year and project_name=:project_name order by month desc", nativeQuery = true)
	Iterable<EmployeeStats> findAllMonthsBeforeCurrent(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "project_name") String project_name);

	@Query(value = "select count(*) from employee_stats where month=:month and year=:year and emp_name=:empName and project_name=:projectName",nativeQuery = true)
	Integer checkEntry(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "empName") String empName,@Param(value = "projectName") String projectName);

	
	@Modifying
	@Transactional
	@Query(value = "update employee_stats set total_task=:totalTask, project_part_progress=:progress where month=:month and year=:year and emp_name=:empName and project_name=:projectName",nativeQuery = true)
	void updateEntryForTotalTask(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "empName") String empName,@Param(value = "totalTask")Integer total_task,@Param(value = "progress") Integer progress, @Param(value = "projectName") String projectName);

	@Query(value = "select total_task from employee_stats where month=:month and year=:year and emp_name=:empName and project_name=:projectName",nativeQuery = true)
	Integer getTotalTask(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "empName") String empName,@Param(value = "projectName")String projectName);

	@Query(value = "select completed_task from employee_stats where month=:month and year=:year and emp_name=:empName and project_name=:projectName",nativeQuery = true)
	Integer getCompletedTask(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "empName") String empName,@Param(value = "projectName") String projectName);

	@Modifying
	@Transactional
	@Query(value = "update employee_stats set completed_task=:completedTask, project_part_progress=:progress where month=:month and year=:year and emp_name=:empName and project_name=:projectName",nativeQuery = true)
	void updateEntryForCompletedTask(@Param(value = "month")Integer month, @Param(value = "year") Integer year, @Param(value = "empName") String empName, @Param(value = "projectName") String projectName,@Param(value = "completedTask")Integer completedTask,@Param(value = "progress")Integer progress);
}
