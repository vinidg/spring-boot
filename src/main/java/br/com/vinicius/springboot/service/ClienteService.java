package br.com.vinicius.springboot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.repository.ClienteRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepositorio repo; 
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
}
