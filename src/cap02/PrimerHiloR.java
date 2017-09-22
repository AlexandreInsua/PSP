package cap02;

public class PrimerHiloR implements Runnable {
	private int x;

	public PrimerHiloR(int x) {
		this.x = x;
	}

	public void run() {
		for (int i = 0; i < x; i++) {
			System.out.println("No fío... " + i);
		}
	}

	public static void main(String[] args) {
		PrimerHiloR p = new PrimerHiloR(10);

		while (true) {
			new Thread(p).start();
		}
		
		
	}
}
