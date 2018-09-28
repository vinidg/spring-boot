package br.com.vinicius.springboot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.repository.ClienteRepositorio;

@Service
public class DbService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instatiateTestDatabase() {
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Maria das Graças");
		cliente1.setCpf("54417644144");
		cliente1.setRg("412425678");
		cliente1.setDataNascimento("10-05-2000");
		cliente1.setPass(encoder.encode("1234567"));
		cliente1.setUser("mariaGraca");

		cliente1.addPerfil(Perfil.ADMIN);
		clienteRepositorio.saveAll(Arrays.asList(cliente1));
		
	}
	
}
