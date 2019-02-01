package br.com.vinicius.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.springboot.domain.EstadoCidade;

@Repository
public interface EstadoCidadeRepository extends MongoRepository<EstadoCidade, String> {

	public List<EstadoCidade> findByOrderByNome();
	public EstadoCidade findByIdOrderByCidadesAsc(String estadoId);
}