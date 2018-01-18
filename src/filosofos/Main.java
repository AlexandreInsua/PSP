package filosofos;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int numf = 7;
		int tempoPensando =10000;
		int tempoComendo =20000;
		
	
		int tiempoParada=50000;
		Random r=new Random();
		Mesa m=new Mesa(numf);
		Filosofo [] arr = new Filosofo [numf];
		
		String [] filosofos={"Platón", "Aristóteles", "Hobes", "Hume", "Maquiavelo", "Descartes", "Marx"};
		
		for(int i=0; i<numf;i++){
			arr[i]=new Filosofo(r, tempoComendo, tempoPensando, m, i, filosofos[i]);
			///arr[i].start();
		}
		
		for(int i=0; i<numf;i++){
			arr[i].start();
		}
		
		for(int i=0; i<numf;i++){
			Thread.sleep(tiempoParada);
			System.out.println("Parando filósofo "+i);
			arr[i].interrupt();
		}
		
		for(int i=0; i<numf;i++){
			arr[i].join();
		}
}}
