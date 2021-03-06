package IngerGYM.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

	private String usuario;
	private String email;
	private boolean situacionLaboral;
	private int edad;
	private String nTelefono;
	private String contrasena;
	//private tarifa tarifa;
	private int precio;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
/*	@ManyToOne
	private Salas Sala;
	*/
	public Cliente() {
		
	}
	public Cliente(String usuario,String email,int edad, String nTelefono, String contrasena,boolean trabajo){
		super();
		this.usuario= usuario;
		this.situacionLaboral=trabajo;
		this.email=email;
		this.edad=edad;
		this.nTelefono= nTelefono;
		this.contrasena= nTelefono;
		//this.precio=tarifa.tarifa(edad,trabajo);
	}

	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
/*
	public Salas getSala() {
		return Sala;
	}

	public void setSala(Salas sala) {
		Sala = sala;
	}
*/
	public String getnTelefono() {
		return nTelefono;
	}

	public void setnTelefono(String nTelefono) {
		this.nTelefono = nTelefono;
	}
	
	@Override
	public String toString() {
		return "Cliente [tlf="  + ", name=" + "usuario ]";
		//return "Cliente [tlf=" + tarifa + ", name=" + "usuario ]";
	}
}