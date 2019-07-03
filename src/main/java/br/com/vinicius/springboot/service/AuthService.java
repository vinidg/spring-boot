package br.com.vinicius.springboot.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.repositories.ClienteRepository;
import br.com.vinicius.springboot.service.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		Optional<Cliente> cliente = clienteRepositorio.findByEmail(email);
		cliente.orElseThrow(() -> new ObjectNotFoundException("Email não encontrado"));
		
		String newPassword = newPassword();
		cliente.get().setPass(encoder.encode(newPassword));
		
		clienteRepositorio.save(cliente.get());
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
