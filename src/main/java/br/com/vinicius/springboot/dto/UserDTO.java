package br.com.vinicius.springboot.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String user;

	public UserDTO() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
