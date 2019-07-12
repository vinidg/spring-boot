package br.com.vinicius.springboot.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.vinicius.springboot.enums.Entrega;

public class RastreioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Entrega entrega;
	private LocalDateTime data;
	
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
}
