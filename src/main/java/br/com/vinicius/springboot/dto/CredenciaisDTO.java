package br.com.vinicius.springboot.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String user;
	private String pass;
	
	public CredenciaisDTO() {
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
