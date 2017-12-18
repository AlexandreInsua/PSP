package cap02;

public class Actividade02_1_tic_tac {
	// main
	public static void main(String[] args) {
		Watch tic = new Watch("tic");
		Watch tac = new Watch("\ttac");

		tic.run();
		tac.run();

	}
}

/*
 * Usa un bucle infinito para ver as mensaxes. Crea d�as clases que extenden
 * Thread. Un dos f�os visualiza TIC e outro TAC. Dentro do bucle usa o m�todo
 * sleep() para que dea tempo a var as palabras.
 * 
 */
class Watch extends Thread {
	String name;
	String message;

	Watch(String m) {

		this.name = m;
		this.message = m;
	}

	public void run() {
		while (true) {
			try {
				System.out.println(this.message);
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("Excepci�n capturada: ");
				ie.printStackTrace();
			}
		}
	}
}