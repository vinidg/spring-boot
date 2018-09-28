package br.com.vinicius.springboot.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.vinicius.springboot.enums.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSS implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	@Getter
	private Integer id;
	private String user;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS(Integer id, String user, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.user = user;
		this.senha = senha;
		this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return user;
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


}
