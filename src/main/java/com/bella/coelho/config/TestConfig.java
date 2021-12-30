package com.bella.coelho.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bella.coelho.entities.Category;
import com.bella.coelho.entities.Client;
import com.bella.coelho.entities.Order;
import com.bella.coelho.entities.Product;
import com.bella.coelho.entities.enums.OrderStatus;
import com.bella.coelho.repositories.CategoryRepository;
import com.bella.coelho.repositories.ClientRepository;
import com.bella.coelho.repositories.OrderRepository;
import com.bella.coelho.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "SemiJoias");
		Category cat2 = new Category(null, "Ouro");
		Category cat3 = new Category(null, "Prata");
		
		Product p1 = new Product(null, "Anel", "anel com pedras", 90.90, null);
		Product p2 = new Product(null, "Brinco", "brinco Brenda", 90.90, null);
		Product p3 = new Product(null, "Colar", "colar ponta de luz", 80.90, null);
		Product p4 = new Product(null, "Pulseira", "pulseira love", 120.90, null);
		Product p5 = new Product(null, "Piercing", "piercing girls", 100.90, null);
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Client c1 = new Client(null, "Maria Silva", "Av Um", 111, "Centro", "Araraquara", "SP", "14800000",
				"16 99999-9999", "maria@gmail.com", "988888888", "65115807092", "01/02/1990");
		Client c2 = new Client(null, "João Silva", "Av Dois", 222, "Centro", "Araraquara", "SP", "14800000",
				"16 98888-9999", "joão@gmail.com", "977776666", "33305309016", "05/04/1980");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, c1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, c2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, c1);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
