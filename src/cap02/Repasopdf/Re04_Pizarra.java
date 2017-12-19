package cap02.Repasopdf;

/*
 * Obxecto compartido.
 */
public class Re04_Pizarra {

	boolean escritoOla = false;

	public synchronized void eOla() {

		System.out.println("Ola");
		escritoOla = true;
		notifyAll();
	}

	public synchronized void eAdeus() {
		while (escritoOla == false) {
			// aínda non escribiu ola,
			// polo que non pode escribir adeus
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			escritoOla = false;
			System.out.println("Adeus");
		}

	}
}
