package br.com.vinicius.springboot.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Categoria;
import br.com.vinicius.springboot.domain.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{

	@Transactional(readOnly=true)
	Optional<Produto> findById(String id);
	
	Page<Produto> findByCategoriasIn(Iterable<Categoria> categorias, Pageable pageRequest);
	
}
