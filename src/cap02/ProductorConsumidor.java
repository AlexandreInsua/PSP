package cap02;
// TODO CÓDIGO DE PEPE


/* Simula os roles d productor e consumidor.
 * produtor vai xerar números aleatorios
 * que o consumidor debe coller e mostralos.
 * 
 */
public class ProductorConsumidor {

	public static void main(String[] args) {
		// Monitor monitor = new Monitor();
		MonitorImplementado mi = new MonitorImplementado(5);
		Productor p = new Productor("prod1", mi, 5);
		Consumidor c = new Consumidor("cons", mi);
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

class MonitorImplementado {
	// precisamos un atributos
	private int numero = 0;
	private int numColaNum;
	private int contNum = 0;
	private int[] colaNumeros = new int[numColaNum];
	private boolean colaLlena = false;
	private boolean colaVacia = true;

	MonitorImplementado(int n) {
		this.numColaNum = n;
	}

	public synchronized int coger() {
		// Se a cola está valeira envia ao fío á cola de espera
		// sae cando colaVaia se false
		imprimeCola(colaNumeros);
		while (colaVacia) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Diminúe contNum porque colle un número e haberá un menos na cola
			contNum--;
			// Se non quedan números
			if (contNum == 0) {
				colaVacia = true; // A cola encontrase valeira
				colaLlena = false;
				// A cola non está chea porque collemos un número
				notify();
			}
		}
		// o fío consumidor colle o número
		return (colaNumeros[contNum]);
	}

	public synchronized void dejar(int numero) {
		// se a cola non está chea, non entran máis números, enviamos o fío á cola de
		// espera
		// Se colaLlena é fals,poderáse continuar producindo
		imprimeCola(colaNumeros);
		while (colaLlena) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// engadimos o novo númeor á cola no primeiro lugar disponible
		colaNumeros[contNum] = numero;
		// aumentamos os núemros na cola
		contNum++;
		// Miramos se a cola está chea
		if (contNum == colaNumeros.length) {
			colaLlena = true;
			colaVacia = false;
			// é false pq acaba de producir un número
			notify();
		}
	}

	private void imprimeCola(int[] colaNumeros) {
		System.out.print("\n[");
		for (int i = 0; i < 5; i++) {
			System.out.print(colaNumeros[i]+" ");
		}
		System.out.print("]\n");
	}

}

// produce números
class Productor implements Runnable {
	private String nombre = "";
	private Monitor bandeja;
private MonitorImplementado band;
	private int numero = 0;
	int cantidad = 1;

	public Productor(String nombre, Monitor s) {
		nombre = nombre;
		bandeja = s;
	}
	public Productor(String nombre, MonitorImplementado s, int n) {
		nombre = nombre;
		band = s;
		cantidad = n;
	}

	@Override
	public void run() {
		// produce 10 numeros
		numero = (int) (Math.random() * cantidad);
		bandeja.dejar(numero);
		System.out.println("Producido el número " + numero);
		try {
			Thread.sleep((int) (Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// consume número
class Consumidor implements Runnable {
	private String nombre = "";
	private int numero = 0;
	private Monitor bandeja;
	private MonitorImplementado band;

	public Consumidor(String nombre, Monitor s) {
		nombre = nombre;
		bandeja = s;
	}

	public Consumidor(String nombre, MonitorImplementado s) {
		nombre = nombre;
		band = s;
	}
	public void run() {
		numero = bandeja.coger();
		for (int i = 0; i < 5; i++) {
			System.out.println("Se ha cogido " + numero);

		}
	}
}