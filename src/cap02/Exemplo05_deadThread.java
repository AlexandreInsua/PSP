package cap02;

/*
 * Exemplo onde se unha unha variable booleana e un m�todo para parar un f�o 
 */
public class Exemplo05_deadThread extends Thread {
	private boolean pararFio = false;

	public void pararFio() {
		pararFio = true;
	}

	@Override
	public void run() {

		while (!pararFio) {
			System.out.println("No f�o... ");
		}
		System.out.println("Detido");
	}

	public static void main(String[] args) {
		Exemplo05_deadThread f = new Exemplo05_deadThread();
		f.start();

		for (int i = 0; i < 100000; i++) {
		}

		f.pararFio();
	}
}
