package api.spring.bluebank.service;

public class ClienteService {
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import api.spring.bluebank.model.Cliente;
import api.spring.bluebank.repository.ClienteRepository;

@Service
public class ClienteService {
	private @Autowired ClienteRepository repository;
	
	public ResponseEntity<Cliente> cadastrarCliente(Cliente novocliente) {
		List<Cliente> clienteExistente = cRepository.findAllById(novocliente.getId());
		List<Cliente> validaCPF = cRepository.findByCpf(novocliente.getCpf());
		if (clienteExistente.isEmpty() && findByCpf.isEmpty()) {
			return ResponseEntity.status(201).body(cRepository.save(novocliente));
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
	
	public Optional<Cliente> alterarEmail(Long id,
			Cliente clienteParaAtualizar) {
		return repository.findById(id).map(emailExistente -> {
			emailExistente.setEmail(clienteParaAtualizar.getEmail());
			return Optional.ofNullable(repository.save(emailExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

