package IngerGYM.repositorios;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import IngerGYM.entidades.Cliente;


public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
	
	
	List<Cliente> findByUser(String nombre);
	List<Cliente> findByEmail(String email);
}