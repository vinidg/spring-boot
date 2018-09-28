package br.com.vinicius.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Perfil {

	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLIENTE");
	
	@Getter
	private int id;
	@Getter
	private String descricao;
	

	public static Perfil toEnum(Integer id) {
		if (id == null)
			return null;
		
		for(Perfil x : Perfil.values()) {
			if(id.equals(x.getId()))
				return x;
		}
		throw new IllegalArgumentException("id inválido " + id);
	}
}
