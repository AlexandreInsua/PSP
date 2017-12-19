package cap02.Repasopdf;

import java.io.IOException;

public class Re07_FiosDemonios extends Thread {
	// array de fios
	private static final int MEDIDA = 10;
	private Thread[] fios = new Thread[MEDIDA];

	public Re07_FiosDemonios() {

		setDaemon(true);
		start();
	}

	// crea n fios
	public void run() {
		for (int i = 0; i < MEDIDA; i++) {
			fios[i] = new CrearDemonio(i);
		}
		for (int i = 0; i < MEDIDA; i++) {
			System.out.println("fio [" + i + "].isDaemon()= " + fios[i].isDaemon());
		}
		while (true)
			// para o fío actual temporalmente e permite que outros se executen
			yield();
	}

	// Clase interna
	class CrearDemonio extends Thread {
		public CrearDemonio(int i) {
			
			// se non nos interesa que un fio sexa daemon, debemos indicalo aqui con
			// setDaemon(false) antes del método start() 
			// do contrario herda a calidade de daemon do seu pai.
			System.out.println("Daemon creado " + i);
			start();
		}

		public void run() {
			while (true)
				yield();
		}
	}

	public static void main(String[] args) throws IOException {
		Thread hilo = new Re07_FiosDemonios();
		System.out.println("isDaemon() = " + hilo.isDaemon());
		System.out.println("Preme unha tecla para finalizar.");
		System.in.read();
	}
}