package br.com.vinicius.springboot.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.Endereco;

public class newPedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private Endereco endereco; 
	
	private List<ItemPedidoDTO> itemPedidos = new ArrayList<>();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedidoDTO> getItemPedidos() {
		return itemPedidos;
	}

	public void setItemPedidos(List<ItemPedidoDTO> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
