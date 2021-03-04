package IngerGYM.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import IngerGYM.entidades.Cliente;


public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
	
}