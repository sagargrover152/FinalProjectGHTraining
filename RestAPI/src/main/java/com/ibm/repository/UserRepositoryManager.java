package com.ibm.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.bean.ManagerDetails;

@Repository
public interface UserRepositoryManager extends CrudRepository<ManagerDetails, Integer> {

	@Query(value = "select full_name from manager_details where availability='YES'",nativeQuery = true)
	Iterable<String> findAllManagersAvailable();

	@Modifying
	@Transactional
	@Query(value ="update manager_details set availability='NO', project_assigned=:projectName where full_name=:managerName", nativeQuery = true)
	void updateManagerWithProjectCreation(@Param(value = "projectName")String projectName, @Param(value = "managerName")String managerName);

	@Modifying
	@Transactional
	@Query(value ="update manager_details set availability='YES', project_assigned='Not Assigned' where project_assigned=:projectName", nativeQuery = true)
	void updateManagerWithProjectEdit(@Param(value = "projectName")String projectName);

}
