package api.spring.bluebank.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.spring.bluebank.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	List<Cliente> findAllById(Long id);
	
	@Query(value = "SELECT * FROM cliente c WHERE c.cpf = :cpf", nativeQuery = true)
	List<Cliente> findByCpf(String cpf);

}
