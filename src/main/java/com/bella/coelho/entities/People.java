package com.bella.coelho.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import java.util.stream.Collectors;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.bella.coelho.entities.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode (of={"id", "cpf"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class People implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@NotNull(message = "O campo NOME é obrigatório")
	@Getter @Setter private String nome;

	@CPF
	@Column(unique = true)
	@NotNull(message = "O campo CPF é obrigatório")
	@Getter @Setter private String cpf;
	
	@Column(unique = true)
	@Getter @Setter private String rg;

	@Column(unique = true)
	@NotNull(message = "O campo EMAIL é obrigatório")
	@Getter @Setter private String email;
	
	@Column(unique = true)
	@NotNull(message = "O campo SENHA é obrigatório")	
	@Getter @Setter private String senha;
	
	@Column(unique = true)
	@Getter @Setter private String logradouro;
	@Getter @Setter private Integer numero;
	@Getter @Setter private String bairro;
	@Getter @Setter private String cidade;
	@Getter @Setter private String estado;
	@Getter @Setter private String cep;
	
	@Column(unique = true)
	@NotNull(message = "O campo TELEFONE é obrigatório")
	@Getter @Setter private String telefone;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNasc;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	protected Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

}
