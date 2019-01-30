package br.com.vinicius.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, Integer> {

	@Transactional(readOnly=true)
	@Query("{ 'id': { $regex: ?0, $options: 'i' } }")
	public List<Cidade> findCidades(Integer estado_id);
}