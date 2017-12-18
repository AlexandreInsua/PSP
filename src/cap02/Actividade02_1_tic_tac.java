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
 * Usa un bucle infinito para ver as mensaxes. Crea dúas clases que extenden
 * Thread. Un dos fíos visualiza TIC e outro TAC. Dentro do bucle usa o método
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
				System.out.println("Excepción capturada: ");
				ie.printStackTrace();
			}
		}
	}
}