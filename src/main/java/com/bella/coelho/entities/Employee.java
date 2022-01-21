package com.bella.coelho.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.bella.coelho.entities.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class Employee extends People {
		private static final long serialVersionUID = 1L;
		
		@JsonIgnore
		@OneToMany(mappedBy = "client")
		private List<Order> orders = new ArrayList<>();
		
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
				String string12, String string13) {
		}

		}
