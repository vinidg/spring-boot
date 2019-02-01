package br.com.vinicius.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.EstadoCidade;
import br.com.vinicius.springboot.repositories.EstadoCidadeRepository;

@Service
public class EstadoCidadeService {
	
	@Autowired
	private EstadoCidadeRepository repo;
	
	public List<EstadoCidade> findAll() {
		return repo.findAll();
	}

	public EstadoCidade findCidades(String estadoId) {
		return repo.findByIdOrderByCidadesAsc(estadoId);
	}
	
}