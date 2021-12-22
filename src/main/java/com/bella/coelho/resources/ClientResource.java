package com.bella.coelho.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bella.coelho.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@GetMapping
	public ResponseEntity<Client> findAll() {
		Client c = new Client(1L, "Maria Silva", "Av Um", 111, "Centro", "Araraquara", "SP", "14800000",
				"16 99999-9999", "maria@gmail.com", "988888888", "65115807092", "01/02/1990");
		return ResponseEntity.ok().body(c);
	}
}
