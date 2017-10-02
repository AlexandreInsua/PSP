package cap02;

import java.security.SecureRandom;

// Implementa un fío extende de thead que simula o lanzamento dun dado de 6 caras
public class Exercicio01 extends Thread {
	boolean stopThread;

	public void stopThread() {
		stopThread = true;
	}

	@Override
	public void run() {
		
		while (!stopThread) {
			SecureRandom sr = new SecureRandom();
			int result = sr.nextInt(6);
			System.out.println(result);

		}

	}

	public static void main(String[] args) {
		Exercicio01 t = new Exercicio01();
		t.run();

	}
}
