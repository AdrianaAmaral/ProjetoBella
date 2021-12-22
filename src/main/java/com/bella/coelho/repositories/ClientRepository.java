package com.bella.coelho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
