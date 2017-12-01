package cap02;

public class PrioridadesDeHilos implements Runnable{
	String strImprimir;
	public PrioridadesDeHilos(String strP) {
		strImprimir = strP;
	}
	
	public void run () {
		for (int i = 0; i < 100; i++) {
			System.out.println(strImprimir);
		}
	}
	public static void main(String[] args) {
		PrioridadesDeHilos objRunable1 = new PrioridadesDeHilos("Corredor 1");
		PrioridadesDeHilos objRunable2 = new PrioridadesDeHilos("Corredor 2");
				PrioridadesDeHilos objRunable3 = new PrioridadesDeHilos("Corredor 2");
				
		// Creamos os fios cos obxectos Runnable
		Thread primero = new  Thread(objRunable1);
		primero.setName("Corredor 1");
		
		Thread segundo= new  Thread(objRunable2);
		segundo.setName("Corredor 2");
		
		Thread tercero= new  Thread(objRunable3);
		tercero.setName("Corredor 3");
		
		// Cambiamos prioridade
		// prioridade baixa
		primero.setPriority(Thread.MIN_PRIORITY);
		System.out.println("Prioridad " + primero.getName() + ": "+ primero.getPriority());
		
		// prioridade alta
		segundo.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Prioridad " + segundo.getName() + ": "+ segundo.getPriority());
		
		segundo.setPriority(5);
		System.out.println("Prioridad " + segundo.getName() + ": "+ segundo.getPriority());
		
		// creamos un tercer núcleo para salvar o problema do doble núcleo
		tercero.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Prioridad " + tercero.getName() + ": "+ tercero.getPriority());
		
		primero.start();
		segundo.start();
		tercero.start();

		// facemos que o main finaliza despois do terceiro
		try {
			tercero.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("Fin Hilo principal");
		
	}
}
