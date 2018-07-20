package com.like.demo.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4739467958100319836L;

	@NotEmpty(message="사용자 아이디는 필수 입력사항입니다.")	
	private String userId;
	
	private String userName;
	
	private String password;

	protected User() {}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
