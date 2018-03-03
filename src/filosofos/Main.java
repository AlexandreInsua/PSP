package filosofos;

import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		int numfilosofos = 7;
		int tempoPensando = 100;
		int tempoComendo = 200;

		int tiempoParada = 50000;
		Random r = new Random();
		Mesa m = new Mesa(numfilosofos);
		Filosofo[] arr = new Filosofo[numfilosofos];

		String[] filosofos = { "Platón", "Aristóteles", "Hobes", "Hume", "Maquiavelo", "Descartes", "Marx" };

		for (int i = 0; i < numfilosofos; i++) {
			arr[i] = new Filosofo(tempoComendo, tempoPensando, m, r, i, filosofos[i]);
			/// arr[i].start();
		}

		for (int i = 0; i < numfilosofos; i++) {
			arr[i].start();
		}

		for (int i = 0; i < numfilosofos; i++) {

			Thread.sleep(tiempoParada);

			System.out.println("Parando filósofo " + i);
			arr[i].interrupt();
		}

		for (int i = 0; i < numfilosofos; i++) {
			arr[i].join();
		}
	}
}
