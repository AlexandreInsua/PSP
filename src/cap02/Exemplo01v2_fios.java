package cap02;

// Clase que xunta a declaraci�n do f�o e o main()
public class Exemplo01v2_fios extends Thread {

	// Atributos, construtores e m�todos da clase
	private int c; // Contador de cada f�o
	private int fio; // Nomea o f�o

	// Construtor
	public Exemplo01v2_fios(int fio) {
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

	public static void main(String[] args) {
		Exemplo01v2_fios f = null;
		// crea os fios 
		for (int i = 0; i < 5; i++) {
			f = new Exemplo01v2_fios(i + 1);
			f.start();
		}
		System.out.println("5 f�os creados...");
	}

}
