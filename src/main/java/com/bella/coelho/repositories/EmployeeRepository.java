package com.bella.coelho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
