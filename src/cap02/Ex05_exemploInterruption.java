package cap02;

public class Ex05_exemploInterruption extends Thread {
	@Override
	public void run() {

		try {
			while (!isInterrupted()) {
				System.out.println("No fío.");
				Thread.sleep(100);
			}
			// O método sleep() é subsceptible de lanzar a unha excepció
		} catch (InterruptedException ie) {
			System.out.println("Ocorreu unha excepción");

		}

		System.out.println("Fin do Fio");
	}

	public void interromper() {
		interrupt();
	}

	public static void main(String[] args) {
		Ex05_exemploInterruption name = new Ex05_exemploInterruption();
		name.start();

		// perde tempo de micro
		for (int i = 0; i < 100; i++) {
			System.out.println("Gastando tempo do micro...");

		}
		name.interromper();
	}
}
