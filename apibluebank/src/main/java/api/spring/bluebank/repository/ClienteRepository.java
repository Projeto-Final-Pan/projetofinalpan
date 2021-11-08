package api.spring.bluebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import api.spring.bluebank.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findAllById(Long id);
	
}
