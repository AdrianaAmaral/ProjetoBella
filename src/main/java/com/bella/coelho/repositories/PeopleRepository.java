package com.bella.coelho.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.People;

public interface PeopleRepository extends JpaRepository<People, Long>{
	
	Optional<People> findByCpf(String cpf);
	Optional<People> findByEmail(String email);

}
