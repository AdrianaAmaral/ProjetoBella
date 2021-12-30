package com.bella.coelho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
