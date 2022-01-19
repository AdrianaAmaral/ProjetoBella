package com.bella.coelho.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bella.coelho.entities.Order;
import com.bella.coelho.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Order>{

}
