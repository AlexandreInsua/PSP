package cap02;

class FioDePrata extends Thread {
	private int c;
	private int fio;

	public FioDePrata(int fio) {
		this.fio = fio;
		System.out.println("creando o " + fio);
	}

	public void run() {
		c = 0;
		while (c < 5) {
			System.out.println("Fío " + c + " C " + c);
			c++;
		}
	}
}

public class Exemplo01_fios_v2 {
	public static void main(String[] args) {
		FioDePrata f = null;
		for (int i = 0; i < 3; i++) {
			f = new FioDePrata(i + 1);
			f.start();
		}
		System.out.println("3 fíos creados...");
	}

}
