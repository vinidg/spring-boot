package br.com.vinicius.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.repositories.ClienteRepository;
import br.com.vinicius.springboot.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepository clienteRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Optional<Cliente> cliente = clienteRepositorio.findByUser(user);
		cliente.orElseThrow(() -> new UsernameNotFoundException(user));
		return new UserSS(cliente.get().getId(), cliente.get().getUser(), cliente.get().getPass(), cliente.get().getPerfis());
	}

}
