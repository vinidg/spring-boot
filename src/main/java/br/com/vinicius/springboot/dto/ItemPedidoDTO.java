package br.com.vinicius.springboot.dto;

import java.io.Serializable;

public class ItemPedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer quantidade;
	private Double preco;
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
