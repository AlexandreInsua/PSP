package cap02;

// Clase que xunta a declaración do fío e o main()
public class Exemplo01v2_fios extends Thread {

	// Atributos, construtores e métodos da clase
	private int c; // Contador de cada fío
	private int fio; // Nomea o fío

	// Construtor
	public Exemplo01v2_fios(int fio) {
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
		Exemplo01v2_fios f = null;
		// crea os fios 
		for (int i = 0; i < 5; i++) {
			f = new Exemplo01v2_fios(i + 1);
			f.start();
		}
		System.out.println("5 fíos creados...");
	}

}
