package br.com.vinicius.springboot.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{

	@Transactional(readOnly=true)
	Optional<Cliente> findByEmail(String email);
}
