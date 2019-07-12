package br.com.vinicius.springboot.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vinicius.springboot.domain.Pedido;
import br.com.vinicius.springboot.dto.newPedidoDTO;
import br.com.vinicius.springboot.service.PedidoService;

@RestController()
@RequestMapping(value="/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Void> add(@Valid @RequestBody newPedidoDTO pedido) {
		Pedido pedidoRealizado = pedidoService.insert(pedido);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pedidoRealizado.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> get(@PathVariable("id") String id){
		Pedido pedido = pedidoService.find(id);
		return ResponseEntity.ok().body(pedido);
	}
	
	@RequestMapping(value="/cliente/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Pedido>> getCliente(@PathVariable("id") String clienteId){
		List<Pedido> listPedidos = pedidoService.findByCliente(clienteId);
		return ResponseEntity.ok().body(listPedidos);
	}
	
}
