package cap02;

public class Exemplo04_deadThread extends Thread {
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
		Exemplo04_deadThread t = new Exemplo04_deadThread();
		t.start();
		for (int i = 0; i < 100000; i++) {
			
		}
t.stopThread();
	}
}
