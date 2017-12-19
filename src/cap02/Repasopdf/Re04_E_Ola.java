package cap02.Repasopdf;

public class Re04_E_Ola implements Runnable {
	Re04_Pizarra piz;

	Re04_E_Ola(Re04_Pizarra piz) {
		this.piz = piz;
		// crea un obxecto
		new Thread(this, "Ola").start();
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(1000);
				piz.eOla();
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

}
