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
import br.com.vinicius.springboot.domain.Endereco;
import br.com.vinicius.springboot.domain.EstadoCidade;
import br.com.vinicius.springboot.domain.Produto;
import br.com.vinicius.springboot.enums.Perfil;
import br.com.vinicius.springboot.repositories.CategoriaRepository;
import br.com.vinicius.springboot.repositories.ClienteRepository;
import br.com.vinicius.springboot.repositories.EnderecoRepository;
import br.com.vinicius.springboot.repositories.EstadoCidadeRepository;
import br.com.vinicius.springboot.repositories.ProdutoRepository;

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
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public void run(String... args) throws Exception {

		clienteRepositorio.deleteAll();
		estadoCidadeRepository.deleteAll();
		categoriaRepository.deleteAll();
		produtoRepository.deleteAll();
		enderecoRepository.deleteAll();
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		
		Produto prod1 = new Produto(null, "Mouse", 12.0, 200, Arrays.asList(cat1));
		Produto prod2 = new Produto(null, "Teclado", 30.8, 200, Arrays.asList(cat1));
		Produto prod3 = new Produto(null, "Monitor", 552.0, 50, Arrays.asList(cat1));
		Produto prod4 = new Produto(null, "Chaves de fenda", 50.5, 67, Arrays.asList(cat2));
		Produto prod5 = new Produto(null, "Copos", 10.0, 90, Arrays.asList(cat3, cat6));
		Produto prod6 = new Produto(null, "Vasos de plantas", 24.5, 345, Arrays.asList(cat3, cat6));
		Produto prod7 = new Produto(null, "Pá de jardinagem", 36.9, 50, Arrays.asList(cat5));
		Produto prod8 = new Produto(null, "Conjunto de talheres", 100.0, 40, Arrays.asList(cat3));
		Produto prod9 = new Produto(null, "Cadeira presidente", 502.5, 23, Arrays.asList(cat2));
		Produto prod10 = new Produto(null, "Mesa de escritório", 324.0, 10, Arrays.asList(cat2));
		Produto prod11 = new Produto(null, "Vela perfumada", 10.0, 210, Arrays.asList(cat7, cat3, cat6));
		Produto prod12 = new Produto(null, "Notebook", 5200.4, 2, Arrays.asList(cat1));
		Produto prod13 = new Produto(null, "Web cam", 240.0, 156, Arrays.asList(cat1));
		Produto prod14 = new Produto(null, "Cabo HDMI", 41.0, 147, Arrays.asList(cat5, cat1));
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11, prod12, prod13, prod14));

		Cliente cliente1 = new Cliente();
		cliente1.setId(null);
		cliente1.setNome("Vinicius Duarte Galdino");
		cliente1.setCpf("41434973875");
		cliente1.setRg("454604385");
		cliente1.setDataNascimento(LocalDate.of(1995, 3, 20));
		cliente1.setPass(encoder.encode("vinidg123"));
		cliente1.setEmail("vinidgdon@gmail.com");
		cliente1.addPerfil(Perfil.ADMIN);
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(null);
		cliente2.setNome("Maria Carla Alveida");
		cliente2.setCpf("1234567890");
		cliente2.setRg("416357478");
		cliente2.setDataNascimento(LocalDate.of(1986, 7, 12));
		cliente2.setPass(encoder.encode("maria123"));
		cliente2.setEmail("maria@gmail.com");
		
		clienteRepositorio.saveAll(Arrays.asList(cliente1, cliente2));
		
		
		URL url = Resources.getResource("estados_cidades.json");
		ObjectMapper mapper = new ObjectMapper();
		EstadoCidade[] estadoCidade = null;
		try {
			estadoCidade = mapper.readValue(Resources.toString(url, Charsets.ISO_8859_1), EstadoCidade[].class);
		} catch (IOException e) {
			throw new Exception(e);
		}
		
		estadoCidadeRepository.saveAll(Arrays.asList(estadoCidade));
		
		
		Endereco enderecoCliente1 = new Endereco();
		enderecoCliente1.setId(null);
		enderecoCliente1.setLogradouro("Av Fagundes de Oliveira");
		enderecoCliente1.setNumero("519");
		enderecoCliente1.setCep("099750300");
		enderecoCliente1.setComplemento("APT 172 Bl Alvorada");
		enderecoCliente1.setBairro("Piraporinha");
		enderecoCliente1.setCidade("Diadema");
		enderecoCliente1.setEstado("São Paulo");
		
		enderecoCliente1.setCliente(cliente1);
		
		enderecoRepository.save(enderecoCliente1);
		
	}
	

}
