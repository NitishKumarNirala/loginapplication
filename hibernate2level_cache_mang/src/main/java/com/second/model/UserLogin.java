package com.second.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * The persistent class for the user_login database table.
 * @author nitish
 * @version 1.0
 */
@Entity
@Table(name="user_login")
@NamedQuery(name="UserLogin.findAll", query="SELECT u FROM UserLogin u")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserLogin implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user key. */
	@Id
	@Column(name="USER_KEY")
	private long userKey;

	/** The login date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LOGIN_DATE")
	private Date loginDate;

	/** The user id. */
	@Column(name="USER_ID")
	private String userId;

	/** The user password. */
	@Column(name="USER_PASSWORD")
	private String userPassword;

	/**
	 * Instantiates a new user login.
	 */
	public UserLogin() {
	}

	/**
	 * Gets the user key.
	 *
	 * @return the user key
	 */
	public long getUserKey() {
		return this.userKey;
	}

	/**
	 * Sets the user key.
	 *
	 * @param userKey the new user key
	 */
	public void setUserKey(long userKey) {
		this.userKey = userKey;
	}

	/**
	 * Gets the login date.
	 *
	 * @return the login date
	 */
	public Date getLoginDate() {
		return this.loginDate;
	}

	/**
	 * Sets the login date.
	 *
	 * @param loginDate the new login date
	 */
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user password.
	 *
	 * @return the user password
	 */
	public String getUserPassword() {
		return this.userPassword;
	}

	/**
	 * Sets the user password.
	 *
	 * @param userPassword the new user password
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}