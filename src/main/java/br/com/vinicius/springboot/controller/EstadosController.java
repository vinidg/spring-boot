package br.com.vinicius.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.springboot.domain.EstadoCidade;
import br.com.vinicius.springboot.dto.EstadoDTO;
import br.com.vinicius.springboot.service.EstadoCidadeService;

@RestController
@RequestMapping(value="/estados")
public class EstadosController {
	
	@Autowired
	private EstadoCidadeService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<EstadoCidade> list = service.findAll();
		List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{estadoId}/cidades", method=RequestMethod.GET)
	public ResponseEntity<List<String>> findCidades(@PathVariable String estadoId) {
		EstadoCidade list = service.findCidades(estadoId);
		List<String> listDTO = list.getCidades();
		return ResponseEntity.ok().body(listDTO);
	}
}