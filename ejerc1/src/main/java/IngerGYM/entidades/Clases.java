package IngerGYM.entidades;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clases {
	
	private String profesor;
	private String tipo; 
	private String nombreSala;
	//private Salas sala;
	private int dia;
	private int hora;
	private int aforo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	public Clases (String prof,String tipo,int dia, int hora) {
		
			this.profesor=prof;
			this.tipo=tipo;
			this.dia=dia;
			this.hora=hora;

	}
	
	public Clases (Salas sala,String prof,String tipo,int dia, int hora) {
		
		this.nombreSala=sala.getNombre();
		if(sala.compHora(dia, hora)==true) {
			sala.cogerHora(dia, hora);
			this.profesor=prof;
			this.tipo=tipo;
			this.dia=dia;
			this.hora=hora;
			this.aforo=sala.getAforoMAX();
		}
		
	
	}
	/*
	public int [] queclase(){
		int i[]=new int [1];
		i[1]=hora;
		i[0]=dia;
		return i;
	}*/

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
/*
	public Salas getSala() {
		return sala;
	}

	public void setSala(Salas sala) {
		this.sala = sala;
	}*/
}