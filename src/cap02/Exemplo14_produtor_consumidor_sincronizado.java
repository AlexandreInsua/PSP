package cap02;

import javax.sql.rowset.spi.SyncResolver;

/*
 * Exemplo que resolve o problema do produtor consumidor sincronizando 
 * os métodos no obxecto compartido.
 */

public class Exemplo14_produtor_consumidor_sincronizado {

	public static void main(String[] args) {
		Cola4 cola = new Cola4();
		Produtor4 p = new Produtor4(cola, 1);
		Consumidor4 c = new Consumidor4(cola, 1);
		p.start();
		c.start();

	}
}

// obxecto compartido
class Cola4 {
	private int numero;
	private boolean disponible = false;

	// Sincronizado
	synchronized public int get() {
		if (disponible) {
			disponible = false;
			return numero;
		}
		return -1;
	}

	// Sincronizdo
	synchronized void put(int i) {
		numero = i;
		disponible = true;
	}

}

// fío produtor

class Produtor4 extends Thread {
	private Cola4 cola;
	private int n;

	public Produtor4(Cola4 cola, int n) {
		this.cola = cola;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
			System.out.println(i + "=> produtor: " + n + ", produce: " + i);
		}
	}
}

// fío consumidor

class Consumidor4 extends Thread {
	private Cola4 cola;
	private int n;

	public Consumidor4(Cola4 cola, int n) {
		this.cola = cola;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			int valor = cola.get();
			System.out.println(i + "=> Consumidor: " + n + ", consume: " + valor);
		}
	}
}
