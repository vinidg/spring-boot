package br.com.vinicius.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.vinicius.springboot.domain.Produto;
import br.com.vinicius.springboot.service.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable String id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Produto> add(@RequestBody @Valid Produto produto, @RequestParam(name="file") MultipartFile file) {
		service.insert(produto, file);
		Produto find = service.find(produto.getId());
		return ResponseEntity.ok().body(find);
	}
	
	//TODO implementar buscar pro produtos inspirado no projeto com pageable
	
}
