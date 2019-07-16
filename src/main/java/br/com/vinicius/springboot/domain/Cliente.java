package br.com.vinicius.springboot.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vinicius.springboot.enums.Perfil;

@Document
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private String pass;
	@Email
	private String email;
	private String playerId;

	private Set<String> perfis = new HashSet<>();

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getId()); 
	}

	public Cliente() {
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(String id, String nome, String cpf, String rg, LocalDate dataNascimento,
			String pass, String email, Set<String> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.setDataNascimento(dataNascimento);
		this.pass = pass;
		this.email = email;
		this.perfis = perfis;
		addPerfil(Perfil.CLIENTE);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPerfis(Set<String> perfis) {
		this.perfis = perfis;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
}
