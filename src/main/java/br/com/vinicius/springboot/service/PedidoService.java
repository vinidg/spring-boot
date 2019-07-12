package br.com.vinicius.springboot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.Pedido;
import br.com.vinicius.springboot.dto.newPedidoDTO;
import br.com.vinicius.springboot.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired ClienteService clienteService;
	
	@Transactional
	public Pedido insert(newPedidoDTO newPedido) {
		Pedido pedidoRealizado = new Pedido(null, LocalDateTime.now(), newPedido.getCliente(), newPedido.getEndereco(), newPedido.getItemPedidos(), false);
		pedidoRealizado = pedidoRepository.save(pedidoRealizado);
		return pedidoRealizado;
	}
	
	public Pedido find(String id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElse(null);	
	}
	
	public List<Pedido> findByCliente(String clienteId){
		Cliente cliente = clienteService.find(clienteId);
		List<Pedido> list = pedidoRepository.findByCliente(cliente);
		return list;
	}
}
