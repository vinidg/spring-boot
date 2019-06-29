package br.com.vinicius.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.Endereco;
import br.com.vinicius.springboot.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	public List<Endereco> findByCliente(String clienteId){
		Cliente cliente = clienteService.find(clienteId);
		List<Endereco> enderecos = enderecoRepository.findByCliente(cliente);
		return enderecos;
	}
	
}
