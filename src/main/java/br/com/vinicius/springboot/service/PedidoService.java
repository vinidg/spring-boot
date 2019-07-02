package br.com.vinicius.springboot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Pedido;
import br.com.vinicius.springboot.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public Pedido insert(Pedido pedido) {
		pedido.setDataDaCompra(LocalDateTime.now());
		return pedidoRepository.insert(pedido);
	}
}
