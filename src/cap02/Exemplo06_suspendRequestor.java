package cap02;

/*  
 * Método obsoleto.
 * Suspender un fio de maneira segura
 */
public class Exemplo06_suspendRequestor extends Thread {
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
