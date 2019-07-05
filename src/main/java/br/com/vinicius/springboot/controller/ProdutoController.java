package br.com.vinicius.springboot.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.vinicius.springboot.domain.Produto;
import br.com.vinicius.springboot.service.ProdutoService;
import br.com.vinicius.springboot.utils.URL;

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
	public ResponseEntity<Page<Produto>> findByCategorias(
			@RequestParam(value="categorias", defaultValue="") String categorias, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		List<String> ids = URL.decodeStringList(categorias);
		Page<Produto> obj = service.findByCategorias(ids, page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<Produto> add(@RequestBody @Valid Produto produto) {
		Produto produtoSalvo = service.insert(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ResponseEntity<Produto> update(@RequestBody @Valid Produto produto, @PathVariable("id") String id) {
		produto.setId(id);
		service.update(produto);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/picture/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> picture(@PathVariable(value="id") String idProduto, @RequestParam(name="file") MultipartFile file){
		URI uri = service.uploadProductPicture(file, idProduto);
		return ResponseEntity.created(uri).build();
	}
	
}
