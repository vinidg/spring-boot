package br.com.vinicius.springboot.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String email;
	private String pass;
	
	public CredenciaisDTO() {
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
