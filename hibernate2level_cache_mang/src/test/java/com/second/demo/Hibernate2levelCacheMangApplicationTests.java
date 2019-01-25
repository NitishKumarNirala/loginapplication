package com.second.demo;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.second.model.UserLogin;
import com.second.service.UserLoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Hibernate2levelCacheMangApplicationTests {
	
	@Autowired
	private UserLoginService userLoginRepository;

	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void createUser() {
		
		UserLogin user=new UserLogin();
		user.setUserId("nitish");
		user.setUserKey(2);
		user.setUserPassword("nitish123");
		Date date=new Date();	
		user.setLoginDate(Timestamp.from(date.toInstant()));
		userLoginRepository.createUser(user);
		
	}
	
	/**
	 * Update password.
	 */
	@Test
	public void updatePassword() {
		userLoginRepository.updateUserPwd("nitish@123",2);
	}
	
	@Test
	public void findUserTest() {
		userLoginRepository.findbykey(2);
	}
	
	@Test
	public void loginUserTest() {
		userLoginRepository.loginUser("nitish","nitish123");
	}

}

