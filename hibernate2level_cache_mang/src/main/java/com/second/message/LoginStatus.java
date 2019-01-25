package com.second.message;

public enum LoginStatus {

	USER_SECCESS(100, "Continue"),
	USER_FAILURE(101, "Continue");

	private final int id;

	private final String msg;

	LoginStatus(int id, String msg) {

		this.id = id;
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public String getMsg() {
		return msg;
	}

}
