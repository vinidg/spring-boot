package br.com.vinicius.springboot.enums;

public enum Perfil {

	ADMIN("1", "ROLE_ADMIN"),
	CLIENTE("2", "ROLE_CLIENTE");

	private String id;
	private String descricao;
	
	private Perfil(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static Perfil toEnum(String id) {
		if (id == null)
			return null;
		
		for(Perfil x : Perfil.values()) {
			if(id.equals(x.getId()))
				return x;
		}
		throw new IllegalArgumentException("id inválido " + id);
	}


	public String getId() {
		return id;
	}


	public String getDescricao() {
		return descricao;
	}
}
