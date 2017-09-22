package cap02;
public class Exemplo01_fios extends Thread {
	private int c;//contador de cada hilo
	private int hilo;
	
	//constructor
	public Exemplo01_fios (int hilo) {
		this.hilo=hilo;
		System.out.println("Creando hilo:" + hilo);
	}
	
	//metodo RUN
	
	public void run() {
		c=0;
		while (c<=5) {
			System.out.println("Hilo: " + hilo +  " c= " + c);
			c++;
		}
	}
	
	public static void main (String[] args) {
		//declaramos una referencia para manipular los hilos
		//de momento no apunta a ningún hilo
		
		Exemplo01_fios h = null;
		
		for (int i = 0; i <3; i++) {
			//creamos el hilo
			h=new Exemplo01_fios(i+1);
			//iniciamos el hilo
			h.start();
			
		}
		System.out.println("Crados tres hilos");
	}
}
