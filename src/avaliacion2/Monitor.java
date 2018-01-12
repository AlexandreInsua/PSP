package avaliacion2;

public class Monitor {
	private int escrEsperando; // numero escritores agardando;
	private int numLect; // numero lectores lendo
	private int numEscr; // número escritores lendo

	/*
	 * escrEsperando >= numEscr 0 <= numEscr <= 1 numLect=>0 numlect > 0 ---> numEsc
	 * = 0
	 */

	public Monitor() {
		escrEsperando = 0;
		numLect = 0;
		numEscr = 0;
	}

	// mentres houber un escritor lendo ou esperando para escribir, os lectores espreas
	public void permisoLer() throws InterruptedException {
		// TODO Auto-generated method stub
		while (numEscr > 0 || escrEsperando > 0) {
			wait();
		}
		numLect++;
	}

	public void finLer() {
		// TODO Auto-generated method stub
		numLect--;
		notifyAll();
	
	}
	
	// mentres haxa lectores agarda, logo escribe
	public synchronized void permisoEscribir() throws InterruptedException {
		escrEsperando++;
		while (numLect > 0) {
			wait();
		}
		numEscr++;
	}

	public void finEscribir() {
		escrEsperando--;
		numEscr--;

	}

	@Override
	public String toString() {
		return "nl:" + numLect + ", ne:" + numEscr + ", ee:" + escrEsperando ;
	}

	
}
