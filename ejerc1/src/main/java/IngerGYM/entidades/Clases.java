package IngerGYM.entidades;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Clases {
	
	private String profesor;
	private String tipo; 
	private String nombreSala;
	private int dia=0;
	private int hora=0;
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
	public Clases (Salas sala,String prof,String tipo) {
		
			this.nombreSala=sala.getNombre();
		
			sala.cogerHora();
			this.profesor=prof;
			this.tipo=tipo;
			this.dia=dia;
			this.hora=hora;
			this.aforo=sala.getAforoMAX();
		
		
	
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
	
	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getTipo() {
		return tipo;
	}

	public int getAf() {
		return aforo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}