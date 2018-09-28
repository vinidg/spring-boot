package br.com.vinicius.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vinicius.springboot.domain.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

	@Transactional(readOnly=true)
	Cliente findByUser(String user);
}
