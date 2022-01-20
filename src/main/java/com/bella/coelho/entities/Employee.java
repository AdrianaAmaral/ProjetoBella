package com.bella.coelho.entities;

import java.util.stream.Collectors;
import javax.persistence.Entity;

import com.bella.coelho.entities.enums.Perfil;

@Entity
public class Employee extends People {
		private static final long serialVersionUID = 1L;
		
		public Employee() {
			super();
			addPerfil(Perfil.FUNCIONARIO);
		}
		
		public Employee(Employee obj) {
			super();
			this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
			addPerfil(Perfil.FUNCIONARIO);
		}

		public Employee(Object object, String string, String string2, String string3, String string4, String string5,
				String string6, int i, String string7, String string8, String string9, String string10, String string11,
				String string12, Object object2, String string13) {
		}
}
