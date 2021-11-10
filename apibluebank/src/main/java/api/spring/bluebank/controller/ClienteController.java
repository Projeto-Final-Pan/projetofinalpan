package api.spring.bluebank.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.spring.bluebank.model.Cliente;
import api.spring.bluebank.repository.ClienteRepository;

/*
 * 
<<<<<<< HEAD
 * @author hanely 
 * cadastro de cliente ok 
 * listagem de cliente ok 
 * atualização de cliente ok 
 * deletar clientes ok 
 * historico de transações entre contas
 * 
 * não deletar se houver saldo
 * limite de pagamento ou transferencia pix
 * validar cpf na hora de cadastrar (regex) api da receita
 * validar idade
 * validar cep -  api
 * criar metodo deposito
 * criar metodo de saque
 * criar metodo de transferencia
 */


@RestController
@RequestMapping("/cliente")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	@Autowired
	private ClienteRepository cRepository;

	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos() {
		return ResponseEntity.ok(cRepository.findAll());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente novocliente) {
		List<Cliente> clienteExistente = cRepository.findAllById(novocliente.getId());
		List<Cliente> validaCPF = cRepository.findByCpf(novocliente.getCpf());
		if (clienteExistente.isEmpty() && validaCPF.isEmpty()) {
			return ResponseEntity.status(201).body(cRepository.save(novocliente));
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@PutMapping("/id/{id}")
	public Optional<Cliente> alterarEmail(@PathVariable(value = "id") Long id,
			@RequestBody Cliente clienteParaAtualizar) {
		return cRepository.findById(id).map(emailExistente -> {
			emailExistente.setEmail(clienteParaAtualizar.getEmail());
			return Optional.ofNullable(cRepository.save(emailExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});

	}

	@DeleteMapping("/id/{id}")
	public void deletar(@PathVariable Long id) {
		cRepository.deleteById(id);
	}
}
