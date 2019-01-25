package com.second.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.second.model.UserLogin;

/**
 * The Interface LoginRepository.
 */
@Repository
@Transactional
public interface LoginRepository extends JpaRepository<UserLogin, Long> {

	/**
	 * Forget password.
	 *
	 * @param passowd the passowd
	 * @param userKey the user key
	 */
	@Modifying
	@Query("update UserLogin u set u.userPassword = ?1 where u.userKey = ?2")
	void forgetPassword(String passowd, long userKey);

	/**
	 * Find by user key.
	 *
	 * @param userKey the user key
	 * @return the list
	 */
	@Query("select t from UserLogin t where t.userKey = ?1")
	List<UserLogin> findByUserKey(long userKey);

	/**
	 * User login secure.
	 *
	 * @param userId the user id
	 * @param password the password
	 * @return true, if successful
	 */
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM UserLogin c WHERE c.userId = ?1 AND c.userPassword=?2")
	boolean userLoginSecure(String userId, String password);
}
