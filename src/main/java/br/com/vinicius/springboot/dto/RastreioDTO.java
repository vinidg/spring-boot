package br.com.vinicius.springboot.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class RastreioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String status;
	private LocalDateTime data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
