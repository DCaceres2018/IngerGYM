package servicios;

import org.springframework.data.domain.Page;
import entidades.Clases;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioClases extends JpaRepository<Clases, Long> {

	
}
