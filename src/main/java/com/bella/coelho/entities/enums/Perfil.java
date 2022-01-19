package com.bella.coelho.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Perfil {

	ADMIN(0, "ADMIN"), FUNCIONARIO(1, "FUNCIONARIO");

	private Integer codigo;
	private String descrição;
	
	public static Perfil toEnum(Integer cod) {
		if(cod == null) {
			return null;
	}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil Inválido");
	}
}

