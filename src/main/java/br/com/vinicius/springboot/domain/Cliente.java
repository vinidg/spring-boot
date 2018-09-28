package br.com.vinicius.springboot.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import br.com.vinicius.springboot.enums.Perfil;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
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
}
