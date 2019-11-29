package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bean.LoginDetails;
import com.ibm.repository.UserRepositoryLogin;

@Service
public class LoginService {
	
	@Autowired
	UserRepositoryLogin repoLogin;

	public Integer validate(LoginDetails credentials) {
		// TODO Auto-generated method stub
		return repoLogin.validate(credentials.getUserName(),credentials.getUserPass());
	}

	
}
