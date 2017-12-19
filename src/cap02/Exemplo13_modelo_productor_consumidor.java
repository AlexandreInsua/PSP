package cap02;

/*
 * Exemplo que representa o modelo de produtor consumidor que describe
 * a situaci�n onde un f�o produce un obxecto que consume outro. Os
 * desfases que se poden producir son a) o produtor produza moi r�pido polo 
 * que o consumidor salta un dato, 
 * b) o consumidor consuma moi r�pido polo que consume o mesmo dato varias veces,
 * ou no recoller ning�n e romper a aplicaci�n 
 * 
 */

public class Exemplo13_modelo_productor_consumidor {
	public static void main(String[] args) {
		Cola4 cola = new Cola4();
		Produtor4 p = new  Produtor4(cola, 1);
		Consumidor4 c = new Consumidor4(cola, 1);
		p.start();
		c.start();

	}
}

// obxecto compartido
/*
 * Define 2 atributos e 2 m�todos. O primeiro atributo garda un enteiro, o
 * segundo un booleano disponible.
 * 
 * O m�todo put() pon un enteiro na cola e fai que estea disponible e O m�todo
 * get() devolve un enteiro se est� disponible e pon a variable a false inicando
 * se a cola est� valeira. Se o n�mero non esta en cola devolve -1;
 * 
 */
class Cola {
	private int numero;
	private boolean disponible = false; // iniciamos a cola est� valeira

	public int get() {
		// devolve o n�mero se est� na cola
		if (disponible) {
			disponible = false;
			return numero;
		}
		// se a cola est� valeira, 
		return -1;
	}

	void put(int i) {
		// coloca o n�mero na cola
		numero = i;
		disponible = true;
	}

}

// f�o produtor
// xera n�meros de 0 a 5 e os pon nunha cola
// fai unha pausa de 100 ms cada vez que coloca un n�mero
class Produtor extends Thread {
	private Cola4 cola;
	private int n;

	public Produtor(Cola4 cola, int n) {
		this.cola = cola;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
			System.out.println(i + "=> produtor: " + n + ", produce: " + i);
			try {
				sleep(100);
			} catch (InterruptedException ie) {
			}
		}
	}
}

// f�o consumidor
// recolle un valor da cola
class Consumidor2 extends Thread {
	private Cola4 cola;
	private int n;

	public Consumidor2(Cola4 cola, int n) {
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