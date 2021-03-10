package IngerGYM.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente {

	private String usuario;
	private String email;
	private int edad;
	private String contrasena;
	private int precio;
	private boolean admin;
	
	
	@OneToMany
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
		this.precio=0;
		this.clases=new ArrayList<>();
	}
	
	public Cliente(String usuario,String email,int edad, String contrasena){
		super();
		this.usuario= usuario;
		
		this.email=email;
		this.edad=edad;
	
		this.contrasena= contrasena;
		this.admin=false;
		
		if(edad<18) {
			this.precio=15;
		}
		else if(edad>65) {
			this.precio=10;
		}
		else {
				this.precio=25;
			
		}
		this.clases=new ArrayList<>();
	}

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void addClass(Clases clase) {
		 clases.add(clase);
			}
	public List<Clases> getListaClases(){
		return clases;
	}
	
	/*public void setOpinion(Opinion opinion) {
		this.opinion=opinion;
	}*/
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
	
	
	@Override
	public String toString() {
		return "Cliente [tlf="  + ", name=" + "usuario ]";
	}
}