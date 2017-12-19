package cap02.Repasopdf;

public class Re06_PrioridadesFios implements Runnable {
	String strImprimir;

	public Re06_PrioridadesFios(String strP) {
		strImprimir = strP;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(strImprimir);
		}
	}

	public static void main(String[] args) {
		Re06_PrioridadesFios obxRunnable1 = new Re06_PrioridadesFios("Corredor 1");
		Re06_PrioridadesFios obxRunnable2 = new Re06_PrioridadesFios("Corredor 2");
		Re06_PrioridadesFios objRunable3 = new Re06_PrioridadesFios("Corredor 2");

		// Creamos os fios cos obxectos Runnable
		Thread primeiro = new Thread(obxRunnable1);
		primeiro.setName("Corredor 1");

		Thread segundo = new Thread(obxRunnable2);
		segundo.setName("Corredor 2");

		Thread terceiro = new Thread(objRunable3);
		terceiro.setName("Corredor 3");

		// Cambiamos prioridade
		// prioridade baixa
		primeiro.setPriority(Thread.MIN_PRIORITY);
		System.out.println("Prioridade " + primeiro.getName() + ": " + primeiro.getPriority());

		// prioridade alta
		segundo.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Prioridade " + segundo.getName() + ": " + segundo.getPriority());

		segundo.setPriority(5);
		System.out.println("Prioridade " + segundo.getName() + ": " + segundo.getPriority());

		// creamos un tercer núcleo para salvar o problema do doble núcleo
		terceiro.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Prioridade " + terceiro.getName() + ": " + terceiro.getPriority());

		primeiro.start();
		segundo.start();
		terceiro.start();

		// facemos que o main finaliza despois do terceiro
		try {
			terceiro.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		System.out.println("Fin fio principal");

	}
}
