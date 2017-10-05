package cap02;

// Clase que xunta a declaración do fío e o main()
public class Exemplo01_fios_v2 extends Thread {

	// Atributos, construtores e métodos da clase
	private int c; // Contador de cada fío
	private int fio; // Nomea o fío

	// Construtor
	public Exemplo01_fios_v2(int fio) {
		this.fio = fio;
		System.out.println("*** Creando fío: " + fio + " ***");
	}

	// Método run()
	public void run() {
		c = 0;
		while (c <= 5) {
			System.out.println("Fío: " + fio + " C = " + c);
			c++;
		}
	}

	public static void main(String[] args) {
		FioEx1 f = null;
		for (int i = 0; i < 3; i++) {
			f = new FioEx1(i + 1);
			f.start();
		}
		System.out.println("3 fíos creados...");
	}

}
