package cap02;

/* 
 * Suspender un fio de maneira segura
 */
public class Exemplo06_suspenRequestor extends Thread {
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
		} catch (InterruptedException ie) {

		}
	}

	// INNER CLASS
	class SuspendRequestor {
		private boolean suspendRequested;

		public synchronized void set(boolean b) {
			suspendRequested = b;
			notifyAll();
		}

		public synchronized void waitForResume() throws InterruptedException {
			while (suspendRequested) {
				wait();
			}
		}
	}
}

