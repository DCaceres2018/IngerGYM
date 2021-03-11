package IngerGYM.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tarifa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	@OneToMany
	private List<Cliente> clientes;
	
	private int precio;

	public Tarifa() {
		
	}

	public Tarifa(int edad) {
		
		
		if(edad<25) {
			this.precio=10;
		}else if(edad>65) {
			this.precio=5;
		}
		else {
			this.precio=15;
		}
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
		
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
