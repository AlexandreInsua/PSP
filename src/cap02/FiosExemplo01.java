package cap02;
/*
 * Crea n fíos estendendo a clase Thread. Mostra a creación e o funcionamento.  
 */

public class FiosExemplo01 {

	public static void main(String[] args) {
		Fio h = null;
		int i;
		for (i = 0; i < 3; i++) {
			// Crea n fíos
			h = new Fio(i + 1);
			// Inicia o fios
			h.start();
		}
		System.out.println("Creáronse " + i + " fíos.");
	}
}

class Fio extends Thread {
	// Contador de cada fío
	private int c;
	private int fio;

	// Construtor
	public Fio(int fio) {
		this.fio = fio;
		System.out.println("Creando fio" + fio);
	}

	// Método run()
	public void run() {
		c = 0;
		while (c < 5) {
			System.out.println("Fío: " + fio + "C: " + c);
			c++;
		}
	}
}
