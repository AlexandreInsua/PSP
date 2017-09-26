package cap02;
/*
 * Crea n f�os estendendo a clase Thread. Mostra a creaci�n e o funcionamento.  
 */

public class FiosExemplo01 {

	public static void main(String[] args) {
		Fio h = null;
		int i;
		for (i = 0; i < 3; i++) {
			// Crea n f�os
			h = new Fio(i + 1);
			// Inicia o fios
			h.start();
		}
		System.out.println("Cre�ronse " + i + " f�os.");
	}
}

class Fio extends Thread {
	// Contador de cada f�o
	private int c;
	private int fio;

	// Construtor
	public Fio(int fio) {
		this.fio = fio;
		System.out.println("Creando fio" + fio);
	}

	// M�todo run()
	public void run() {
		c = 0;
		while (c < 5) {
			System.out.println("F�o: " + fio + "C: " + c);
			c++;
		}
	}
}
