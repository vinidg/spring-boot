package br.com.vinicius.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.springboot.domain.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {

	public List<Categoria> findByOrderByNome();
}
