package br.com.vinicius.springboot.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.repository.ClienteRepositorio;
import br.com.vinicius.springboot.service.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String user) {
		Cliente cliente = clienteRepositorio.findByUser(user);
		
		if(cliente == null) {
			throw new ObjectNotFoundException("User não encontrado");
		}
		
		String newPassword = newPassword();
		cliente.setPass(encoder.encode(newPassword));
		
		clienteRepositorio.save(cliente);
	}

	private String newPassword() {
		char[] vet = new char[10];
		
		for (int i = 0; i < vet.length; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) {
			return (char) (rand.nextInt(10) + 48);
		}else if(opt == 1) {
			return (char) (rand.nextInt(10) + 65);
		}else {
			return (char) (rand.nextInt(10) + 97);
		}
	}
	
}
