package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Cliente;


public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
	
}