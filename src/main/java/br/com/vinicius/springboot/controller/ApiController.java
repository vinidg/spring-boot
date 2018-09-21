package br.com.vinicius.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.service.ClienteService;

@RestController
@RequestMapping(value = "/service")
public class ApiController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/cliente/list", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getList() {
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok().body(clientes);
	}

}
