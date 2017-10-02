package cap02;

public class Exemplo04_deathThread extends Thread {
	private boolean stopThread = false;

	public void stopThread() {
		stopThread = true;
	}

	@Override
	public void run() {
		int i =0; while (!stopThread) {
			
			System.out.println("No fío... "+i);
			i++;
		}
		System.out.println("Detido");
	}

	public static void main(String[] args) {
		Exemplo04_deathThread t = new Exemplo04_deathThread();
		t.start();
		for (int i = 0; i < 100000; i++) {
			
		}
t.stopThread();
	}
}
