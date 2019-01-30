package br.com.vinicius.springboot.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vinicius.springboot.enums.Perfil;

@Document
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@NotEmpty
	private String nome;
	
	@CPF
	private String cpf;
	
	private String rg;
	
	private String dataNascimento;
	
	@NotEmpty
	private String pass;
	
	@NotEmpty
	private String user;

	private Set<Integer> perfis = new HashSet<>();

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getId()); 
	}

	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(int id, @NotEmpty String nome, @CPF String cpf, String rg, String dataNascimento,
			@NotEmpty String pass, @NotEmpty String user, Set<Integer> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.pass = pass;
		this.user = user;
		this.perfis = perfis;
		addPerfil(Perfil.CLIENTE);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPerfis(Set<Integer> perfis) {
		this.perfis = perfis;
	}
}
