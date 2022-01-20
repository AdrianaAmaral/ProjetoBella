package com.bella.coelho.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Client;
import com.bella.coelho.entities.People;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
}
