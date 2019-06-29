package br.com.vinicius.springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.springboot.domain.Pedido;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>{

}
