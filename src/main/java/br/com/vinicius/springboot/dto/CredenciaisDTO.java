package br.com.vinicius.springboot.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredenciaisDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String user;
	private String pass;
	
}
