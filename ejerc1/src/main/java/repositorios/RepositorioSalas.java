package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Salas;


public interface RepositorioSalas extends JpaRepository<Salas, Long> {
	
}
