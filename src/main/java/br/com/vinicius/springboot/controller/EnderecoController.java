package br.com.vinicius.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.springboot.domain.Endereco;
import br.com.vinicius.springboot.service.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	
	@RequestMapping(value="/cliente/{id}", method=RequestMethod.POST)
	public ResponseEntity<List<Endereco>> get(@PathVariable("id") String clienteId){
		List<Endereco> endereco = service.findByCliente(clienteId);
		
		return ResponseEntity.ok().body(endereco);
	}
	
}
