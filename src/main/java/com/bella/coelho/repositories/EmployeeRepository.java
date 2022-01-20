package com.bella.coelho.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Employee;
import com.bella.coelho.entities.People;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
