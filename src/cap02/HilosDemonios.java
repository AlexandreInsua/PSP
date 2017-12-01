package cap02;

import java.io.IOException;

public class HilosDemonios extends Thread {
	// array de Hilos
	private static final int MEDIDA = 10;
	private Thread[] hilos = new Thread[MEDIDA];

	public HilosDemonios() {
		setDaemon(true);
		start();
	}
// crea n fios
	public void run() {
		for (int i = 0; i < MEDIDA; i++) {
			hilos[i] = new CrearDemonio(i);
		}
		for (int i = 0; i < MEDIDA; i++) {
			System.out.println("hilos [" + i + "].isDaemon()= " + hilos[i].isDaemon());
		}
		while (true)
			yield();
	}
// Clase interna
	class CrearDemonio extends Thread {
		public CrearDemonio(int i) {
			// si un hilo no nos interesa que sea demonio, debemos indicar aquí con
			// setDaemon(false); antes del método start () o de lo contrario, hereda la
			// calidad de demonio de su padre.
			System.out.println("Demonio creado " + i);
			start();
		}

		public void run() {
			while (true)
				yield();
		}
	}

	public static void main(String[] args) throws IOException {
		Thread hilo = new HilosDemonios();
		System.out.println("isDaemon() = " + hilo.isDaemon());
		System.out.println("Pulsa una tecla para finalizar");
		System.in.read();
	}
}