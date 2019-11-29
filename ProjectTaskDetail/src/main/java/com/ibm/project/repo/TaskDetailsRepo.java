package com.ibm.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.project.bean.Tasks;

public interface TaskDetailsRepo extends CrudRepository<Tasks, Integer> {

	Iterable<Tasks> findByProjectName(String projectName);

	@Modifying
	@Transactional
	@Query(value = "delete from tasks where task_name= :taskTitle", nativeQuery = true)
	void deleteTaskWithTaskOwner(@Param(value = "taskTitle") String taskTitle);

	@Modifying
	@Transactional
	@Query(value = "update tasks set task_details = :taskDetails"
			+ ",end_date = :endDate,task_owner = :taskOwnr "
			+ "WHERE task_name = :taskTitle", nativeQuery = true)
	void updateTaskWithTaskOwner(@Param(value = "taskDetails") String taskDetails,
								@Param(value = "endDate") String endDate,
								@Param(value = "taskOwnr") String taskOwnr,
								@Param(value = "taskTitle") String taskTitle
								
								
								);

	@Modifying
	@Transactional
	@Query(value = "update tasks set status=:taskStatus "
			+ "WHERE task_name = :taskTitle", nativeQuery = true)
	void updateStatus(@Param(value="taskStatus")String taskStatus, @Param(value="taskTitle")String taskTitle);

	@Modifying
	@Transactional
	@Query(value = "update tasks set task_owner='Not assigned' where task_owner=:employeeName and status=''", nativeQuery = true)
	void updateTaskWithDeleteEmployee(@Param(value = "employeeName")String employeeName);

	@Query(value = "select project_name from tasks where task_name=:taskTitle",nativeQuery = true)
	String findProjectName(@Param(value = "taskTitle")String taskTitle);

}