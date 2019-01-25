package com.second.service;

import java.util.List;

import com.second.model.UserLogin;

/**
 * The Interface UserLoginService.
 */
public interface UserLoginService {
	
	
	/**
	 * Creates the user.
	 *
	 * @param create the create
	 */
	public void createUser(UserLogin create);
	
	/**
	 * Update user pwd.
	 *
	 * @param update the update
	 * @return the user login
	 */
	public void updateUserPwd(String pass,long userKey);
	
	/**
	 * Login user.
	 *
	 * @param userId the user id
	 * @param pass the pass
	 * @return true, if successful
	 */
	public boolean loginUser(String userId, String pass);
	
	
	/**
	 * Findbykey.
	 * @param <T>
	 *
	 * @param key the key
	 * @return the list
	 */
	public <T> List<T>findbykey(long key);

}
