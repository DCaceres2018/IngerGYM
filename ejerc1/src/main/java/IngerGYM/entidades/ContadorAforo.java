package IngerGYM.entidades;

public class ContadorAforo {

		private int aforo;
		private int maxaforo;
		private int[] horario=new int[56];
		
		public ContadorAforo(Clases clase) {
			this.maxaforo=clase.getAf();
			this.aforo=0;
		}
		
		public boolean hayHueco(int d,int h) {
			int numero=d*7+h;
			if(horario[numero]==1) return false;
			if(aforo<maxaforo) return true;
			else return false;
		}
		
		public void cogeAforo(int d,int h) {
			int n=d*7+h;
			aforo++;
			if(aforo==maxaforo)horario[n]=1;
		}
}
