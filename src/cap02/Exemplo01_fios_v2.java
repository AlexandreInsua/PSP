package cap02;

// Clase que xunta a declaraci�n do f�o e o main()
public class Exemplo01_fios_v2 extends Thread {

	// Atributos, construtores e m�todos da clase
	private int c; // Contador de cada f�o
	private int fio; // Nomea o f�o

	// Construtor
	public Exemplo01_fios_v2(int fio) {
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
		FioEx1 f = null;
		for (int i = 0; i < 3; i++) {
			f = new FioEx1(i + 1);
			f.start();
		}
		System.out.println("3 f�os creados...");
	}

}
