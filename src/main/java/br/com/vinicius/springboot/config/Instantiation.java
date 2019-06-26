package br.com.vinicius.springboot.config;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import br.com.vinicius.springboot.domain.Categoria;
import br.com.vinicius.springboot.domain.Cliente;
import br.com.vinicius.springboot.domain.EstadoCidade;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.repositories.CategoriaRepository;
import br.com.vinicius.springboot.repositories.ClienteRepository;
import br.com.vinicius.springboot.repositories.EstadoCidadeRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepositorio;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private EstadoCidadeRepository estadoCidadeRepository;
	

	@Override
	public void run(String... args) throws Exception {

		clienteRepositorio.deleteAll();
		categoriaRepository.deleteAll();
		estadoCidadeRepository.deleteAll();
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));

		Cliente cliente1 = new Cliente();
		cliente1.setId(null);
		cliente1.setNome("Vinicius Duarte Galdino");
		cliente1.setCpf("41434973875");
		cliente1.setRg("454604385");
		cliente1.setDataNascimento(LocalDate.of(1995, 3, 20));
		cliente1.setPass(encoder.encode("vinidg123"));
		cliente1.setUser("Vinicius");

		cliente1.addPerfil(Perfil.ADMIN);
		clienteRepositorio.saveAll(Arrays.asList(cliente1));
		
		URL url = Resources.getResource("estados_cidades.json");
		ObjectMapper mapper = new ObjectMapper();
		EstadoCidade[] estadoCidade = null;
		try {
			estadoCidade = mapper.readValue(Resources.toString(url, Charsets.UTF_8), EstadoCidade[].class);
		} catch (IOException e) {
			throw new Exception(e);
		}		
		estadoCidadeRepository.saveAll(Arrays.asList(estadoCidade));
		
	}

}
