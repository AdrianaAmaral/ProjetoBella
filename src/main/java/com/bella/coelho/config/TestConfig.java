package com.bella.coelho.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bella.coelho.entities.Client;
import com.bella.coelho.entities.Order;
import com.bella.coelho.repositories.ClientRepository;
import com.bella.coelho.repositories.OrderRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		Client c1 = new Client(null, "Maria Silva", "Av Um", 111, "Centro", "Araraquara", "SP", "14800000",
				"16 99999-9999", "maria@gmail.com", "988888888", "65115807092", "01/02/1990");
		Client c2 = new Client(null, "João Silva", "Av Dois", 222, "Centro", "Araraquara", "SP", "14800000",
				"16 98888-9999", "joão@gmail.com", "977776666", "33305309016", "05/04/1980");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), c1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), c2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), c1);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
