package api.spring.bluebank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.spring.bluebank.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findAllById(Long id);
	
	@Query(value = "SELECT * FROM cliente c WHERE c.cpf= :cpf ", nativeQuery = true)
	List<Cliente>findCPF(String cpf);
}
