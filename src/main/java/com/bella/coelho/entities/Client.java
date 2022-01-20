package com.bella.coelho.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client extends People {
	
	public Client(Object object, String string, String string2, String string3, String string4, String string5,
			String string6, int i, String string7, String string8, String string9, String string10, String string11,
			String string12, Object object2, String string13) {
		
	}

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
			
}

