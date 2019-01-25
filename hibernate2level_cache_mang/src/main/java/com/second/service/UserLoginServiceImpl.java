package com.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.second.model.UserLogin;
import com.second.repository.LoginRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserLoginServiceImpl.
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	/** The login repository. */
	@Autowired
	private LoginRepository loginRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.second.service.UserLoginService#createUser(com.second.model.UserLogin)
	 */
	@Override
	public void createUser(UserLogin create) {
		this.loginRepository.save(create);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.second.service.UserLoginService#loginUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean loginUser(String userId, String pass) {
		System.out.println("value===="+this.loginRepository.userLoginSecure(userId, pass));
		return this.loginRepository.userLoginSecure(userId, pass);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.second.service.UserLoginService#updateUserPwd(long,
	 * java.lang.String)
	 */
	@Override
	public void updateUserPwd(String pass, long userKey) {
		this.loginRepository.forgetPassword(pass, userKey);
	}

	/* (non-Javadoc)
	 * @see com.second.service.UserLoginService#findbykey(long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findbykey(long key) {
		return (List<T>) this.loginRepository.findByUserKey(key);
	}

}
