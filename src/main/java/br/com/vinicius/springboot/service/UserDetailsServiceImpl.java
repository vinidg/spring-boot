package br.com.vinicius.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.repository.ClienteRepositorio;
import br.com.vinicius.springboot.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		Cliente cliente = clienteRepositorio.findByUser(user);
		if (cliente == null) {
			throw new UsernameNotFoundException(user);
		}
		return new UserSS(cliente.getId(), cliente.getUser(), cliente.getPass(), cliente.getPerfis());
	}

}
