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

import br.com.vinicius.springboot.domain.Endereco;
import br.com.vinicius.springboot.service.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	
	@RequestMapping(value="/cliente/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Endereco>> get(@PathVariable("id") String clienteId){
		List<Endereco> endereco = service.findByCliente(clienteId);
		
		return ResponseEntity.ok().body(endereco);
	}
	
	@RequestMapping(value="/cliente/{id}/add", method=RequestMethod.POST)
	public ResponseEntity<Endereco> add(@RequestBody @Valid Endereco endereco, @PathVariable("id") String clienteId){
		Endereco enderecoSalvo = service.insert(endereco, clienteId);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/cliente/{id}").buildAndExpand(enderecoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
