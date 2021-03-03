package servicios;

import org.springframework.data.domain.Page;
import entidades.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioClientes extends JpaRepository<Cliente, Long> {

	
}