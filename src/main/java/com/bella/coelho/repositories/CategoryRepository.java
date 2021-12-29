package com.bella.coelho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
