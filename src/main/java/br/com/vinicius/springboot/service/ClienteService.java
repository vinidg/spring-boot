package br.com.vinicius.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.execeptions.AuthorizationException;
import br.com.vinicius.springboot.repository.ClienteRepositorio;
import br.com.vinicius.springboot.security.UserSS;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
	@Autowired
	private ClienteRepositorio repo; 
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setPass(crypt.encode(obj.getPass()));
		obj = repo.save(obj);
		return obj;
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente find(int id) {
		UserSS user = UserService.authenticated();
		
		if(user == null || !user.hasRole(Perfil.ADMIN) && !(id == user.getId())) {
			throw new AuthorizationException("Acesso Negado");
		}
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);		
	}
	
	public Cliente findByUser(String user) throws ObjectNotFoundException {
	
		Cliente obj = repo.findByUser(user);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
}
