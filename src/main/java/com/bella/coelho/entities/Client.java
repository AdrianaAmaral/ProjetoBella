package com.bella.coelho.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Data
@EqualsAndHashCode (of={"id", "cpf"})
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Column(unique = true)
	private String nome;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private String email;
	private String rg;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNasc;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	@Getter private List<Order> orders = new ArrayList<>();
	
	public Client(Object object, String string, String string2, int i, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11) {
		
	}
	
}

