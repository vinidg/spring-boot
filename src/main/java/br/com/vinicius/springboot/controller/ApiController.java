package br.com.vinicius.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ApiController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getList() {
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Cliente> add(@RequestBody @Valid Cliente cliente){
		Cliente clienteSalvo = clienteService.insert(cliente);
		Cliente find = clienteService.find(clienteSalvo.getId());
		return ResponseEntity.ok().body(find);
	}
	
	@RequestMapping(value = "/find/{clienteId}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable("clienteId") int id) {
		Cliente cliente = clienteService.find(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@RequestMapping(value = "/findbyuser", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@RequestParam(value="value") String user) {
		Cliente cliente = clienteService.findByUser(user);
		return ResponseEntity.ok().body(cliente);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ResponseEntity<String> admin() {
		return ResponseEntity.ok().body("<b>AREA ADMIN</b>");
	}
	
}
