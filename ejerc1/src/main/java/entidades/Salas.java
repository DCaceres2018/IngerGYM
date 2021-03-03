package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salas {
	
	private int aforoMAX;
	private String nombre;
	private int horarios[][]=new int [7][13];
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	public Salas(String a,int n) {
	this.nombre=a;
	this.aforoMAX=n;
	}

	
	public boolean compHora(int d, int h) {
		if(horarios[d][h]==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public void cogerHora(int d, int h) {
		if(horarios[d][h]==0) {
			horarios[d][h]=1;
		}
		
	
	}
	
	public int getAforoMAX() {
		return aforoMAX;
	}

	public void setAforoMAX(int aforoMAX) {
		this.aforoMAX = aforoMAX;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int[][] getHorarios() {
		return horarios;
	}

	public void setHorarios(int[][] horarios) {
		this.horarios = horarios;
	}
	
}