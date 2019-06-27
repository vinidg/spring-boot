package br.com.vinicius.springboot.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.execeptions.AuthorizationException;
import br.com.vinicius.springboot.repositories.ClienteRepository;
import br.com.vinicius.springboot.security.UserSS;
import br.com.vinicius.springboot.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private S3Service s3Service;
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setPass(crypt.encode(obj.getPass()));
		obj = repo.save(obj);
		return obj;
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente find(String id) {
		UserSS user = UserService.authenticated();
		
		if(user == null || !user.hasRole(Perfil.ADMIN) && !(id.equals(user.getId()))) {
			throw new AuthorizationException("Acesso Negado");
		}
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);		
	}
	
	public Cliente findByUser(String user) {
	
		Optional<Cliente> obj = repo.findByUser(user);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + ", Tipo: " + Cliente.class.getName()));
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		return s3Service.uploadFile(multipartFile);
	}
}
