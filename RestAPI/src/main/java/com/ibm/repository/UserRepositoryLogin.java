package com.ibm.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ibm.bean.LoginDetails;

public interface UserRepositoryLogin extends CrudRepository<LoginDetails, Integer> {

	@Query(value = "select count(*) from login_detail where user_name=:userName and password=:userPass or email=:userName and password=:userPass",nativeQuery = true)
	Integer validate(@Param(value = "userName")String userName, @Param(value = "userPass")String userPass);

}
