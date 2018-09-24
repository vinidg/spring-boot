package br.com.vinicius.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.repository.ClienteRepositorio;

@Service
public class ClienteService {
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
	@Autowired
	private ClienteRepositorio repo; 
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setPass(crypt.encode(obj.getPass()));
		obj = repo.save(obj);
		return obj;
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente find(int id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);		
	}
}
