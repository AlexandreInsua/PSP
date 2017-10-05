package cap02;

public class Exemplo_01_fios {

	// Main para instarciar os fios e correlos
	public static void main(String[] args) {
		// Reserva espazo en memorio
		FioEx1 h = null;
		// Instancia e arrinca 3 obxectos. Cada obxecto ter� como nome un n�mero
		for (int i = 0; i < 3; i++) {
			// Instancia o obxecto
			h = new FioEx1(i + 1);
			// Inicia o obxecto
			h.start();
		}
		System.out.println("*** Tres f�os creados ***");
	}
}

// Primeira maneira de crear un fio: estendendo a clase Thread
class FioEx1 extends Thread {
	// Atributos, construtores e m�todos da clase
	private int c; // Contador de cada f�o
	private int fio; // Nomea o f�o

	// Construtor
	public FioEx1(int fio) {
		this.fio = fio;
		System.out.println("*** Creando f�o: " + fio + " ***");
	}

	// M�todo run()
	public void run() {
		c = 0;
		while (c <= 5) {
			System.out.println("F�o: " + fio + " C = " + c);
			c++;
		}
	}
}