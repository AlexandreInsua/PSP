package cap02;

import com.sun.management.jmx.Trace;
import com.sun.swing.internal.plaf.synth.resources.synth;

/* Simula os roles d productor e consumidor.
 * produtor vai xerar números aleatorios
 * que o consumidor debe coller e mostralos.
 * 
 */
public class ProductorConsumidor {

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		Productor p = new Productor("prod1", monitor);
		Consumidor c = new Consumidor("cons", monitor);
		Thread produtor = new Thread(p);
		Thread consumidor = new Thread(c);

		produtor.start();
		consumidor.start();

	}

}

// recipiente de números que ten dous métodos que despois comparte os fios
class Monitor {
	// precisamos un atributos
	private int numero = 0;

	Monitor() {
		numero = 0;
	}

	public synchronized int coger() {
		return numero;

	}

	public synchronized int dejar(int numero) {

		return numero;
	}
}

class Productor implements Runnable {
	private String nombre = "";
	private Monitor bandeja;

	private int numero = 0;

	public Productor(String nombre, Monitor s) {
		nombre = nombre;
		bandeja = s;
	}

	@Override
	public void run() {
		// produce 10 numeros
		numero = (int) (Math.random() * 10+1);
		bandeja.dejar(numero);
		System.out.println("Producido el número " + numero);
		try {
			Thread.sleep((int) (Math.random() * 10)+1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumidor implements Runnable {
	private String nombre = "";
	private int numero = 0;
	private Monitor bandeja;

	public Consumidor(String nombre, Monitor s) {
		nombre = nombre;
		bandeja = s;
	}

	public void run() {
		numero = bandeja.coger();
		for (int i = 0; i < 5; i++) {
			System.out.println("Se ha cogido " + numero);

		}
	}
}