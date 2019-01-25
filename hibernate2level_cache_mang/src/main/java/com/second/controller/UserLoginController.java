package com.second.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.second.message.LoginStatus;
import com.second.model.UserLogin;
import com.second.service.UserLoginService;

@RestController
@RequestMapping("/login")
public class UserLoginController {

	private static final Log LOG=LogFactory.getLog(UserLoginController.class);
	@Autowired
	private UserLoginService userLoginService;

	
	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserLogin> createUser(@RequestBody UserLogin user) {
		user.setLoginDate(Timestamp.from(new Date().toInstant()));
		try {
			userLoginService.createUser(user);
		} catch (Exception e) {
			new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/getloginById/{key}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public <T> List<T> findExistUser(@PathVariable long key ){
		return (List<T>) userLoginService.findbykey(key);
		
	}
	
	@PutMapping(value="/update", consumes = "application/json", produces = "application/json")
	public <T> ResponseEntity<T>updateUserDetails(@RequestBody UserLogin user){
		userLoginService.updateUserPwd(user.getUserPassword(), user.getUserKey());
		return new ResponseEntity<T>(HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping(value="/userlogin",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserLogin>useLogin(@RequestParam("userId") String userId,@RequestParam("userPassword" )String userPassword ){
		
		boolean success=userLoginService.loginUser(userId,userPassword);
		if(success) {
			LOG.info("User Login sucessfully"+LoginStatus.USER_SECCESS);
			return new ResponseEntity<UserLogin>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<UserLogin>(HttpStatus.BAD_REQUEST);
		
	}

}
