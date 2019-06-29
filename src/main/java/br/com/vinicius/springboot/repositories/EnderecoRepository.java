package br.com.vinicius.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.Endereco;

@Repository
public interface EnderecoRepository extends MongoRepository<Endereco, String>{

	@Transactional(readOnly=true)
	List<Endereco> findByCliente(Cliente cliente);
}
