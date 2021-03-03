package servicios;

import org.springframework.data.domain.Page;
import entidades.Salas;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioSalas extends JpaRepository<Salas, Long> {

	
}