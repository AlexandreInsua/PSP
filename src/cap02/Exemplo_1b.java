package cap02;

/*
 * Método obsoleto.
 */

public class Exemplo_1b extends Thread {
	private SuspendRequestor suspender = new SuspendRequestor();

	public void requestSuspend() {
		suspender.set(true);
	}

	public void requestResume() {
		suspender.set(false);
	}

	public void run() {
		try {
			while (true) {
				suspender.waitForResume();
			}
		} catch (InterruptedException e) {

		}
	}
}

class SuspendRequestor {
	private boolean suspendRequested;

	public synchronized void set(boolean b) {
		suspendRequested = b;
		notifyAll();
	}

	public synchronized void waitForResume() throws InterruptedException {
		while (suspendRequested)
			wait();
	}
}
