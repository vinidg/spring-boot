package br.com.vinicius.springboot.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.vinicius.springboot.enums.Perfil;

public class UserSS implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String email;
	private String pass;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS(String id, String email, String pass, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasRole(Perfil perfil) {
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}

	public String getId() {
		return id;
	}

	public UserSS() {
	}

}
