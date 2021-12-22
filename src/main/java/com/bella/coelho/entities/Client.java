package com.bella.coelho.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode (of={"id", "cpf"})
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Column(unique = true)
	@Getter @Setter private String nome;
	@Getter @Setter private String logradouro;
	@Getter @Setter private Integer numero;
	@Getter @Setter private String bairro;
	@Getter @Setter private String cidade;
	@Getter @Setter private String estado;
	@Getter @Setter private String cep;
	@Getter @Setter private String telefone;
	@Getter @Setter private String email;
	@Getter @Setter private String RG;
	
	@CPF
	@Column(unique = true)
	@Getter @Setter private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Getter @Setter private LocalDate dataNasc;
	

}

