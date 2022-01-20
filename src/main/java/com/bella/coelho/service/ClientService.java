package com.bella.coelho.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bella.coelho.entities.Client;
import com.bella.coelho.entities.People;
import com.bella.coelho.repositories.ClientRepository;
import com.bella.coelho.repositories.PeopleRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	
	public List<Client> findAll() {
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.get();
	}
	
	public Client insert(Client obj) {
		obj.setId(null);
		validaPorCpfEEmail(obj);
		Client newObj = new Client();
		return repository.save(newObj);
	}
	
	public void delete(Long id) {
		Client obj = findById(id);
		
		if (obj.getOrders().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui um pedido aberto e não pode ser deletado!");
		} else {
		repository.deleteById(id);
		}
	}
	
	public Client update(Long id, @Valid Client obj) {
		Client entity = repository.getById(id);
		updateData(entity, obj);
		
		obj.setId(id);
		Client entityObj = findById(id);
		
		if (!obj.getSenha().equals(entityObj.getSenha()))
			obj.setSenha(obj.getSenha());

		validaPorCpfEEmail(obj);
		entityObj = new Client();
		return repository.save(entity);

	}

	private void updateData(Client entity, Client obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setLogradouro(obj.getLogradouro());
		entity.setNumero(obj.getNumero());
		entity.setBairro(obj.getBairro());
		entity.setCidade(obj.getCidade());
		entity.setEstado(obj.getEstado());
		entity.setCep(obj.getCep());
		entity.setTelefone(obj.getTelefone());
	}
	
	private void validaPorCpfEEmail(Client obj) {
		Optional<People> newObj = peopleRepository.findByCpf(obj.getCpf());
		if (newObj.isPresent() && newObj.get().getId() != obj.getId()) {
			throw new DataIntegrityViolationException("CPF Cadastrado!");
		}

		newObj = peopleRepository.findByEmail(obj.getEmail());
		if (newObj.isPresent() && newObj.get().getId() != obj.getId()) {
			throw new DataIntegrityViolationException("E-mail Cadastrado!");
		}
	}
}
