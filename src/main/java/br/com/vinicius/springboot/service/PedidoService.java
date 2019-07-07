package br.com.vinicius.springboot.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Pedido;
import br.com.vinicius.springboot.dto.newPedidoDTO;
import br.com.vinicius.springboot.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public Pedido insert(newPedidoDTO newPedido) {
		Pedido pedidoRealizado = new Pedido(null, LocalDateTime.now(), newPedido.getCliente(), newPedido.getEndereco(), newPedido.getItemPedidos());
		pedidoRealizado = pedidoRepository.save(pedidoRealizado);
		return pedidoRealizado;
	}
	
	public Pedido find(String id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElse(null);	
	}
}
