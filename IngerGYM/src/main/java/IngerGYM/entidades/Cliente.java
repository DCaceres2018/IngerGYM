package IngerGYM.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	private String usuario;
	private String email;
	private int edad;
	private String contrasena;
	private boolean admin;
	
	
	@ManyToMany
	protected List<Clases> clases;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	public Cliente() {
		
	}
	public Cliente(boolean admin) {
		
		this.usuario="admin";
		this.contrasena="abcd";
		this.email="IngerGym@gmail.com";
		this.edad=0;
		this.admin=true;
		this.clases=new ArrayList<>();
	}
	
	public Cliente(String usuario,String email,int edad, String contrasena){
		super();
		this.usuario= usuario;
		this.email=email;
		this.edad=edad;
		this.contrasena= contrasena;
		this.admin=false;
		this.clases=new ArrayList<>();
		
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public void addClase(Clases clase) {
		 clases.add(clase);
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
	
	public List<Clases> getClases() {
		return clases;
	}
	
	public void setClases(List<Clases> clases) {
		this.clases = clases;
	}
	@Override
	public String toString() {
		return "Cliente [tlf="  + ", name=" + "usuario ]";
	}
}