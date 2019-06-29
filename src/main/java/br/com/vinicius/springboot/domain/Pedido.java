package br.com.vinicius.springboot.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vinicius.springboot.dto.ItemPedidoDTO;

@Document
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private LocalDateTime dataDaCompra;
	
	@DBRef
	private Cliente cliente;
	
	@DBRef
	private Endereco endereco; 
	
	private List<ItemPedidoDTO> itemPedidos = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDataDaCompra() {
		return dataDaCompra;
	}

	public void setDataDaCompra(LocalDateTime dataDaCompra) {
		this.dataDaCompra = dataDaCompra;
	}

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
