package br.com.vinicius.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>{

	@Transactional(readOnly=true)
	List<Pedido> findByCliente(Cliente clienteId);

}
