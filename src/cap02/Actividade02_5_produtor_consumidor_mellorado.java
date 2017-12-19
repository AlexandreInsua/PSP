package cap02;

/*
 * Anulando o sleep() non se resolve o problema
 */
public class Actividade02_5_produtor_consumidor_mellorado {
public static void main(String[] args) {
		Cola3 cola = new Cola3();
		Produtor3 p = new  Produtor3(cola, 1);
		Consumidor3 c = new Consumidor3(cola, 1);
		p.start();
		c.start();

	}
}

class Cola3 {
	private int numero;
	private boolean disponible = false; // iniciamos a cola está valeira

	public int get() {
		// devolve o número se está na cola
		if (disponible) {
			disponible = false;
			return numero;
		}
		// se a cola está valeira, 
		return -1;
	}

	void put(int i) {
		// coloca o número na cola
		numero = i;
		disponible = true;
	}

}
class Produtor3 extends Thread {
	private Cola3 cola;
	private int n;

	public Produtor3(Cola3 cola, int n) {
		this.cola = cola;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
			System.out.println(i + "=> produtor: " + n + ", produce: " + i);

			// ANULAMOS O SLEEP() 
			
			// try {
			// sleep(100);
			// } catch (InterruptedException ie) {
			// }
		}
	}
}

class Consumidor3 extends Thread {
	private Cola3 cola;
	private int n;

	public Consumidor3(Cola3 cola, int n) {
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