package IngerGYM.entidades;

public class tarifa {

	
	
	public int tarifa(int edad,boolean trabajo) {
		int n=0;
		if(edad<18) {
			n=15;
		}
		if(edad>65) {
			n=10;
		}
		else {
			
			if(trabajo==false) {
				n=18;
			}
			else {
				n=25;
			}
			
		
		}
		
		return n;
	}
}