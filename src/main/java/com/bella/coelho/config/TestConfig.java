package com.bella.coelho.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bella.coelho.entities.Category;
import com.bella.coelho.entities.Client;
import com.bella.coelho.entities.Employee;
import com.bella.coelho.entities.Order;
import com.bella.coelho.entities.OrderItem;
import com.bella.coelho.entities.Payment;
import com.bella.coelho.entities.Product;
import com.bella.coelho.entities.enums.OrderStatus;
import com.bella.coelho.entities.enums.Perfil;
import com.bella.coelho.repositories.CategoryRepository;
import com.bella.coelho.repositories.OrderItemRepository;
import com.bella.coelho.repositories.OrderRepository;
import com.bella.coelho.repositories.PeopleRepository;
import com.bella.coelho.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	public void instanciaDB() {
		
		Employee e1 = new Employee(null, "Rosana Silva", "78144530039", "97788888", "rosanasilva@gmail.com",
				"123", "Rua Três", 134, "Centro", "Araraquara", "SP", "14800000", "(16) 99999-2222", 
				"15/06/1990", "20/01/2022"); 
		e1.addPerfil(Perfil.FUNCIONARIO);
		Employee e2 = new Employee(null, "Adriana Silva", "19235946050", "96688888", "adrianasilva@gmail.com",
				"123", "Rua Quatro", 534, "Centro", "Araraquara", "SP", "14800000", "(16) 99999-3333", 
				"25/07/1991", "20/01/2022");
		e2.addPerfil(Perfil.ADMIN);
					
		Client c1 = new Client(null, "Antonio Silva", "02171207094", "98888888", "antoniosilva@gmail.com",
				"123", "Rua Um", 1234, "Centro", "Araraquara", "SP", "14800000", "(16) 99999-0000", 
				"10/02/1970", "20/01/2022");
		Client c2 = new Client(null, "Joao Silva", "72870145055", "99988888", "joaosilva@gmail.com",
				"124", "Rua Dois", 234, "Centro", "Araraquara", "SP", "14800000", "(16) 99999-1111", 
				"12/06/1980", "20/01/2022");
		
		Category cat1 = new Category(null, "SemiJoias");
		Category cat2 = new Category(null, "Ouro");
		Category cat3 = new Category(null, "Prata");
		
		Product p1 = new Product(null, "Anel", "anel com pedras", 90.90, null, null);
		Product p2 = new Product(null, "Brinco", "brinco Brenda", 90.90, null, null);
		Product p3 = new Product(null, "Colar", "colar ponta de luz", 80.90, null, null);
		Product p4 = new Product(null, "Pulseira", "pulseira love", 120.90, null, null);
		Product p5 = new Product(null, "Piercing", "piercing girls", 100.90, null, null);
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		Order o1 = new Order(null, Instant.parse("2022-01-20T08:53:07Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2022-01-20T09:42:10Z"), OrderStatus.WAITING_PAYMENT, c2);
		Order o3 = new Order(null, Instant.parse("2022-01-20T10:21:22Z"), OrderStatus.WAITING_PAYMENT, c1);
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		peopleRepository.saveAll(Arrays.asList(e1, e2, c1, c2));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));	
			
		Payment pay1 = new Payment(null, Instant.parse("2022-01-20T10:00:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
		
	}

}
