package com.bella.coelho.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bella.coelho.entities.Employee;
import com.bella.coelho.entities.People;
import com.bella.coelho.repositories.EmployeeRepository;
import com.bella.coelho.repositories.PeopleRepository;
import com.bella.coelho.service.exceptions.DatabaseException;
import com.bella.coelho.service.exceptions.ResourceNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	public List<Employee> findAll() {
		return repository.findAll();
	}
	
	public Employee findById(Long id) {
		Optional<People> obj = peopleRepository.findById(id);
		return (Employee) obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Employee insert(Employee obj) {
		obj.setId(null);
		validaPorCpfEEmail(obj);
		Employee newObj = new Employee();
		return repository.save(newObj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Employee update(Long id, Employee obj) {
		try {
		Employee entity = repository.getById(id);
		updateData(entity, obj);
		
		obj.setId(id);
		Employee entityObj = findById(id);
		
		if (!obj.getSenha().equals(entityObj.getSenha()))
			obj.setSenha(obj.getSenha());

		validaPorCpfEEmail(obj);
		entityObj = new Employee();
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(Employee entity, Employee obj) {
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
	
	private void validaPorCpfEEmail(Employee obj) {
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
