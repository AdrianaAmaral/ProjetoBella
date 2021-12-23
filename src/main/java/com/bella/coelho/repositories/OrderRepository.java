package com.bella.coelho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
