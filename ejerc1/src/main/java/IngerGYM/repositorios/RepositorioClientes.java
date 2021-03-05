package IngerGYM.repositorios;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IngerGYM.entidades.Cliente;


@Repository
public interface RepositorioClientes extends JpaRepository<Cliente, Long> {
	
//public Cliente findByNombre(String nombre);

//public boolean existsByNombreAndEmail(String nombre,String email);
}