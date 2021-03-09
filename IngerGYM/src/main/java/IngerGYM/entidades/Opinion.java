package IngerGYM.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import IngerGYM.repositorios.RepositorioClientes;
import IngerGYM.servicios.ServicioClientes;


@Entity
public class Opinion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	//private ServicioClientes servicio;
	@OneToOne
	private Cliente cliente;
	
	
	private String comentario;

	public Opinion() {

	}

	public Opinion(String comentario,Cliente cliente) {
		super();
		this.cliente=cliente;
		this.comentario = comentario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}*/

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	

}